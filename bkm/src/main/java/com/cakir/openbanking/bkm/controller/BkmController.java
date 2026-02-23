package com.cakir.openbanking.bkm.controller;

import com.cakir.openbanking.bkm.dto.*;
import com.cakir.openbanking.bkm.service.BankEntityService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/bkm")
public class BkmController {

    private final BankEntityService bankEntityService;
    private final RestTemplate restTemplate;

    public BkmController(BankEntityService bankEntityService, RestTemplate restTemplate) {
        this.bankEntityService = bankEntityService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/hesap-bilgisi-rizasi")
    public HesapBilgiRizasiIstegiResponse hesapBilgisiRizasi(@RequestBody HesapBilgisiRizasiIstegi req){
        if (req == null){
            throw new IllegalArgumentException("Request body cannot be null");
        }

        if (req.getTckn() == null || req.getTckn().isEmpty()){
            throw new IllegalArgumentException("TCKN is required");
        }

        // hhs ve yos kodunu da kontrol ettir boş olmasın

        BankDTO bankDTO = bankEntityService.getBankByCode(req.getHhsKod());

        String url = bankDTO.getApiUrl() + "/hesap-bilgisi-rizasi";

        return restTemplate.postForObject(url, req, HesapBilgiRizasiIstegiResponse.class);
    }

    @PostMapping("/erisim-belirteci")
    public String erisimBelirteci(@RequestBody ErisimBelirteciIstegi req){
        if (req == null){
            throw new IllegalArgumentException("Request body cannot be null");
        }

        if (req.getRizaNo() == null || req.getRizaNo().isEmpty()){
            throw new IllegalArgumentException("riza no is required");
        }

        BankDTO bankDTO = bankEntityService.getBankByCode(req.getHhsKod());

        String url = bankDTO.getApiUrl() + "/erisim-belirteci";

        return restTemplate.postForObject(url, req, String.class);
    }

    @GetMapping("/hesaplar/{erisimBelirteci}")
    public List<HesapDTO> hesaplar(@PathVariable("erisimBelirteci") String erisimBelirteci){
        BankDTO bankDTO = getBankByErisimBelirteci(erisimBelirteci);

        String url = bankDTO.getApiUrl() + "/hesaplar/" + erisimBelirteci;

        HesapDTO[] hesaplarArray = restTemplate.getForObject(url, HesapDTO[].class);

        if (hesaplarArray != null){
            return Arrays.asList(hesaplarArray);
        }

        return Collections.emptyList();
    }


    @GetMapping("/bakiye/{erisimBelirteci}")
    public List<BakiyeDTO> bakiye(@PathVariable("erisimBelirteci") String erisimBelirteci){
        BankDTO bankDTO = getBankByErisimBelirteci(erisimBelirteci);

        String url = bankDTO.getApiUrl() + "/bakiye/" + erisimBelirteci;

        BakiyeDTO[] bakiyeArray = restTemplate.getForObject(url, BakiyeDTO[].class);

        if (bakiyeArray != null){
            return Arrays.asList(bakiyeArray);
        }

        return Collections.emptyList();
    }














    private BankDTO getBankByErisimBelirteci(String erisimBelirteci){
        if (erisimBelirteci.equals("ACCESSTOKENabcd1234")){
            return bankEntityService.getBankByCode("0001");
        }

        throw new IllegalArgumentException("Invalid access token");
    }
}
