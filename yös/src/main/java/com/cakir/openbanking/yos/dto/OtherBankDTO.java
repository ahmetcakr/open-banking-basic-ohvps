package com.cakir.openbanking.yos.dto;

public class OtherBankDTO {
    private Long id;
    private String bankName;
    private String apiUrl;
    private String code;

    public OtherBankDTO(Long id, String bankName, String apiUrl, String code) {
        this.id = id;
        this.bankName = bankName;
        this.apiUrl = apiUrl;
        this.code = code;
    }

    public OtherBankDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
