package com.cakir.openbanking.bkm.dto;

public class ErisimBelirteciIstegi {
    private String rizaNo;
    private String hhsKod;
    private String yosKod;

    public ErisimBelirteciIstegi(String rizaNo, String hhsKod, String yosKod) {
        this.rizaNo = rizaNo;
        this.hhsKod = hhsKod;
        this.yosKod = yosKod;
    }

    public ErisimBelirteciIstegi() {
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

    public String getRizaNo() {
        return rizaNo;
    }

    public void setRizaNo(String rizaNo) {
        this.rizaNo = rizaNo;
    }
}
