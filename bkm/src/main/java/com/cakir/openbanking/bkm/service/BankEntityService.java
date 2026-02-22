package com.cakir.openbanking.bkm.service;

import com.cakir.openbanking.bkm.dto.BankDTO;
import com.cakir.openbanking.bkm.enums.BankType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankEntityService {

    public List<BankDTO> getAllBanks() {
        return List.of(
                new BankDTO(1L, "ABank", BankType.HHS, "0001", "http://localhost:9005/open-banking"),
                new BankDTO(2L, "BBank", BankType.YOS, "0002", "http://localhost:7005/open-banking")
        );
    }

    public BankDTO getBankByCode(String code) {
        return getAllBanks().stream()
                .filter(bank -> bank.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Bank not found with code: " + code));
    }

    public List<BankDTO> getBanksFromType(BankType bankType) {
        return getAllBanks().stream()
                .filter(bank -> bank.getBankType() == bankType)
                .toList();
    }
}
