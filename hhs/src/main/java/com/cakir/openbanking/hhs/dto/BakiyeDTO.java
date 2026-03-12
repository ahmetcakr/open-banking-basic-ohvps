package com.cakir.openbanking.hhs.dto;

public class BakiyeDTO {
    private String hspNo;
    private String prBrm;
    private String bkyTtr;

    public BakiyeDTO() {
    }

    public BakiyeDTO(String hspNo, String prBrm, String bkyTtr) {
        this.hspNo = hspNo;
        this.prBrm = prBrm;
        this.bkyTtr = bkyTtr;
    }

    public String getHspNo() {
        return hspNo;
    }

    public void setHspNo(String hspNo) {
        this.hspNo = hspNo;
    }

    public String getPrBrm() {
        return prBrm;
    }

    public void setPrBrm(String prBrm) {
        this.prBrm = prBrm;
    }

    public String getBkyTtr() {
        return bkyTtr;
    }

    public void setBkyTtr(String bkyTtr) {
        this.bkyTtr = bkyTtr;
    }
}
