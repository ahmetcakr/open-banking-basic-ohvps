package com.cakir.openbanking.yos.controller;

import com.cakir.openbanking.yos.dto.AccountDTO;
import com.cakir.openbanking.yos.dto.BalanceDTO;
import com.cakir.openbanking.yos.dto.OtherBankDTO;
import com.cakir.openbanking.yos.dto.RequestAccountInfoDTO;
import com.cakir.openbanking.yos.service.OpenBankingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/open-banking")
@CrossOrigin(origins = "*")
public class OpenBankingController {

    private final OpenBankingService openBankingService;

    public OpenBankingController(OpenBankingService openBankingService) {
        this.openBankingService = openBankingService;
    }

    @GetMapping("/getOtherBanks")
    private List<OtherBankDTO> getOtherBanks(){
        return openBankingService.getOtherBanks();
    }

    @PostMapping("requestMyAccountInfoToOtherBank")
    private String requestMyAccountInfoToOtherBank(@RequestBody RequestAccountInfoDTO requestDTO){
        return openBankingService.requestMyAccountInfoToOtherBank(requestDTO);
    }

    @GetMapping("/getMyAccountsFromOtherBank")
    private List<AccountDTO> getMyAccountsFromOtherBank(){
        return openBankingService.getMyAccountsFromOtherBank();
    }

    @GetMapping("/getMyBalancesFromOtherBank")
    private List<BalanceDTO> getMyBalancesFromOtherBank(){
        return openBankingService.getMyBalancesFromOtherBank();
    }
}
