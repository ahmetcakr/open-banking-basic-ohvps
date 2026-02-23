package com.cakir.openbanking.bkm.dto;

public class HesapBilgisiRizasiIstegi {
    private String hhsKod;
    private String yosKod;
    private String tckn;

    public HesapBilgisiRizasiIstegi() {
    }

    public HesapBilgisiRizasiIstegi(String hhsKod, String yosKod, String tckn) {
        this.hhsKod = hhsKod;
        this.yosKod = yosKod;
        this.tckn = tckn;
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
