package com.cakir.openbanking.bkm.dto;

import com.cakir.openbanking.bkm.enums.BankType;

public class BankDTO {
    private Long id;
    private String name;
    private BankType bankType;
    private String code;
    private String apiUrl;

    public BankDTO(Long id, String name, BankType bankType, String code, String apiUrl) {
        this.id = id;
        this.name = name;
        this.bankType = bankType;
        this.code = code;
        this.apiUrl = apiUrl;
    }

    public BankDTO() {
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankType getBankType() {
        return bankType;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
