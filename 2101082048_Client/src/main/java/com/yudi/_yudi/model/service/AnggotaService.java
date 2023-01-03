/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi._yudi.model.service;

import com.google.gson.Gson;
import com.yudi._yudi.model.Anggota;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

/**
 *
 * @author user
 */
public class AnggotaService {
     private String url = "http://localhost:9011";
    
    public Anggota getAnggota(Long anggotaId){
        Anggota anggota = Unirest.get(url + "/anggota/"+anggotaId)
                .asObject(Anggota.class)
                .getBody();
        return anggota;
    }
    
    public Anggota saveAnggota(Anggota anggota){
        HttpResponse<JsonNode> response = Unirest.post(url + "/anggota")
                .header("Content-Type", "application/json")
                .body(anggota)
                .asJson();
        Gson gson = new Gson();
        return gson.fromJson(response.getBody().toString(), Anggota.class);
    }
}
