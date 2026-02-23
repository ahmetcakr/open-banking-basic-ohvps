package com.cakir.openbanking.bkm.dto;

public class HesapBilgiRizasiIstegiResponse {
    private String rizaNo;
    private String hhsKod;
    private String yosKod;
    private String tckn;

    public HesapBilgiRizasiIstegiResponse() {
    }

    public HesapBilgiRizasiIstegiResponse(String rizaNo, String hhsKod, String yosKod, String tckn) {
        this.rizaNo = rizaNo;
        this.hhsKod = hhsKod;
        this.yosKod = yosKod;
        this.tckn = tckn;
    }

    public String getRizaNo() {
        return rizaNo;
    }

    public void setRizaNo(String rizaNo) {
        this.rizaNo = rizaNo;
    }

    public String getHhsKod() {
        return hhsKod;
    }

    public void setHhsKod(String hhsKod) {
        this.hhsKod = hhsKod;
    }

    public String getYosKod() {
        return yosKod;
    }

    public void setYosKod(String yosKod) {
        this.yosKod = yosKod;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }
}
