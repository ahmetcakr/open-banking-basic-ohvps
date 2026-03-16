package com.cakir.openbanking.yos.service;

import com.cakir.openbanking.yos.dto.AccountDTO;
import com.cakir.openbanking.yos.dto.BalanceDTO;
import com.cakir.openbanking.yos.dto.OtherBankDTO;
import com.cakir.openbanking.yos.dto.RequestAccountInfoDTO;
import com.cakir.openbanking.yos.dto.bkm.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

@Service
public class OpenBankingService {

    private static final String BKM_API_URL = "http://localhost:8080";
    private static final String LIST_ENDPOINT = "/bkm-list";
    private static final String BKM_ENDPOINT = "/bkm";
    private static final String YOS_CODE = "0002";

    private final RestTemplate restTemplate;

    public OpenBankingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // 1) kullanıcı hesaplarını çekebileceği bankaları görüntüler OK
    // 2) herhangi bir bankayı seçer ve hesap rızası isteği gönderir (erisim belirteci)
    // 3) hesaplarını listeler
    // 4) hesaplarının bakiyelerini listeler

    public List<OtherBankDTO> getOtherBanks(){
        BankDTO[] bankDTOS = restTemplate.getForObject(BKM_API_URL + LIST_ENDPOINT + "/hhs", BankDTO[].class);

        if (bankDTOS == null){
            return List.of();
        }

        return Stream.of(bankDTOS).map(bank -> new OtherBankDTO(bank.getId(), bank.getName(), bank.getApiUrl(), bank.getCode())).toList();
    }

    public String requestMyAccountInfoToOtherBank(RequestAccountInfoDTO requestDTO){
        HesapBilgisiRizasiIstegi hesapBilgisiRizasiIstegi = new HesapBilgisiRizasiIstegi(requestDTO.getHhsCode(), YOS_CODE, "1234567890");

        HesapBilgiRizasiIstegiResponse hesapBilgiRizasiIstegiResponse = restTemplate.
                postForObject(BKM_API_URL + BKM_ENDPOINT + "/hesap-bilgisi-rizasi", hesapBilgisiRizasiIstegi,
                        HesapBilgiRizasiIstegiResponse.class);

        if (hesapBilgiRizasiIstegiResponse == null){
            throw new RuntimeException("Hesap Bilgisi Rızası Verilemedi.");
        }

        ErisimBelirteciIstegi erisimBelirteciIstegi = new ErisimBelirteciIstegi(
                hesapBilgiRizasiIstegiResponse.getRizaNo(), requestDTO.getHhsCode(), YOS_CODE);

        String erisimBelirteci = restTemplate.
                postForObject(BKM_API_URL + BKM_ENDPOINT + "/erisim-belirteci", erisimBelirteciIstegi, String.class);

        if (erisimBelirteci == null){
            throw new RuntimeException("Erisim belirteci alınamadı.");
        }

        return erisimBelirteci;
    }

    public List<AccountDTO> getMyAccountsFromOtherBank(){
        String accessToken = "ACCESSTOKENabcd1234";

        HesapDTO[] hesapDTOS = restTemplate.getForObject(BKM_API_URL + BKM_ENDPOINT + "/hesaplar/" + accessToken, HesapDTO[].class);

        if (hesapDTOS == null){
            return List.of();
        }

        return Stream.of(hesapDTOS).map(x -> new AccountDTO(x.getHspNo(), x.getHspShb(), x.getPrBrm(), x.getHspDrm())).toList();
    }

    public List<BalanceDTO> getMyBalancesFromOtherBank(){
        String accessToken = "ACCESSTOKENabcd1234";

        BakiyeDTO[] bakiyeDTOS = restTemplate.getForObject(BKM_API_URL + BKM_ENDPOINT + "/bakiye/" + accessToken, BakiyeDTO[].class);

        if (bakiyeDTOS == null){
            return List.of();
        }

        return Stream.of(bakiyeDTOS).map(x -> new BalanceDTO(x.getHspNo(), x.getPrBrm(), x.getBkyTtr())).toList();
    }



}
