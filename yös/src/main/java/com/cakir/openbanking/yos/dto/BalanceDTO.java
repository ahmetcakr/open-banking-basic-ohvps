package com.cakir.openbanking.yos.dto;

public class BalanceDTO {
    private String accountNo;
    private String currency;
    private String balanceAmount;

    public BalanceDTO(String accountNo, String currency, String balanceAmount) {
        this.accountNo = accountNo;
        this.currency = currency;
        this.balanceAmount = balanceAmount;
    }

    public BalanceDTO() {
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(String balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
