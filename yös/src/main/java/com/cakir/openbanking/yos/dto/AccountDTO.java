package com.cakir.openbanking.yos.dto;

public class AccountDTO {
    private String accountNo;
    private String accountOwner;
    private String currency;
    private Boolean isActive;

    public AccountDTO(String accountNo, String accountOwner, String currency, Boolean isActive) {
        this.accountNo = accountNo;
        this.accountOwner = accountOwner;
        this.currency = currency;
        this.isActive = isActive;
    }

    public AccountDTO() {
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
