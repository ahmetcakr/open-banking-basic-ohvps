package com.cakir.openbanking.hhs.dto;

public class HesapDTO {
    private String hspDrm;
    private String hspNo;
    private String hspShb;
    private String prBrm;

    public HesapDTO() {
    }

    public HesapDTO(String hspDrm, String hspNo, String hspShb, String prBrm) {
        this.hspDrm = hspDrm;
        this.hspNo = hspNo;
        this.hspShb = hspShb;
        this.prBrm = prBrm;
    }

    public String getHspDrm() {
        return hspDrm;
    }

    public void setHspDrm(String hspDrm) {
        this.hspDrm = hspDrm;
    }

    public String getHspNo() {
        return hspNo;
    }

    public void setHspNo(String hspNo) {
        this.hspNo = hspNo;
    }

    public String getHspShb() {
        return hspShb;
    }

    public void setHspShb(String hspShb) {
        this.hspShb = hspShb;
    }

    public String getPrBrm() {
        return prBrm;
    }

    public void setPrBrm(String prBrm) {
        this.prBrm = prBrm;
    }
}
