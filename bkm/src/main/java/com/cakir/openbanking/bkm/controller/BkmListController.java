package com.cakir.openbanking.bkm.controller;

import com.cakir.openbanking.bkm.dto.BankDTO;
import com.cakir.openbanking.bkm.enums.BankType;
import com.cakir.openbanking.bkm.service.BankEntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bkm-list")
public class BkmListController {

    private final BankEntityService bankEntityService;

    public BkmListController(BankEntityService bankEntityService) {
        this.bankEntityService = bankEntityService;
    }

    // sadece yös destekleyen kurumlar bu endpoint'e erişebilir. YOS : Müşterisinin bir başka bankadaki verisini kendi app'inde gösterebilen kurumlardır.
    @GetMapping("/hhs")
    public List<BankDTO> getYosList() {

        return bankEntityService.getBanksFromType(BankType.HHS);
    }

    // sadece hhs destekleyen kurumalr bu endpoint'e erişebilir. HHS : Müşterisinin hesabını / kartını - rızası dahilinde - bir başka kurum ile paylaşabilen kurumlardır.
    @GetMapping("/yos")
    public List<BankDTO> getHhsList() {
        return bankEntityService.getBanksFromType(BankType.YOS);
    }
}
