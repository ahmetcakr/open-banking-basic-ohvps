package com.cakir.openbanking.hhs.controller;

import com.cakir.openbanking.hhs.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("open-banking")
public class OpenBankingController {

    @PostMapping("/hesap-bilgisi-rizasi")
    public HesapBilgiRizasiIstegiResponse hesapBilgisiRizasi(@RequestBody HesapBilgisiRizasiIstegi req){

        HesapBilgiRizasiIstegiResponse resp = new HesapBilgiRizasiIstegiResponse();
        resp.setRizaNo("RIZA-"+"abcd1234");
        resp.setTckn(req.getTckn());
        resp.setHhsKod(req.getHhsKod());
        resp.setYosKod(req.getYosKod());

        return resp;
    }

    @PostMapping("/erisim-belirteci")
    public String erisimBelirteci(@RequestBody ErisimBelirteciIstegi req){

        if (req.getYosKod().equals("0002")){
            return "ACCESSTOKENabcd1234";
        }

        throw new IllegalArgumentException("unexcepted.error");
    }

    @GetMapping("/hesaplar/{erisimBelirteci}")
    public List<HesapDTO> hesaplar(@PathVariable("erisimBelirteci") String erisimBelirteci){

        if (erisimBelirteci.equals("ACCESSTOKENabcd1234")){
            return List.of(
              new HesapDTO(true, "TR1000000", "AHMET ÇAKIR", "TRY"),
              new HesapDTO(false, "TR2000000", "AHMET ÇAKIR", "USD")
            );
        }

        return List.of();
    }


    @GetMapping("/bakiye/{erisimBelirteci}")
    public List<BakiyeDTO> bakiye(@PathVariable("erisimBelirteci") String erisimBelirteci){
        if (erisimBelirteci.equals("ACCESSTOKENabcd1234")){
            return List.of(
                new BakiyeDTO("TR1000000", "TRY", "1000"),
                new BakiyeDTO("TR2000000", "USD", "5000")
            );
        }

        return List.of();
    }

}
