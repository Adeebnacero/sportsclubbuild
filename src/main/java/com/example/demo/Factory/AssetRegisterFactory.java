package com.example.demo.Factory;

import com.example.demo.Domain.AssetRegister;

import java.util.Date;

/**
 * Created by Adeebo on 2017/08/26.
 */
public class AssetRegisterFactory {

    public static AssetRegister buildAssetRegister(Date date, String assetName, String assetDescription, float assetValue, int assetQuantity, String assetState){

        AssetRegister assetRegister = new AssetRegister.Builder()
                .setDate(date)
                .setAssetName(assetName)
                .setAssetDescription(assetDescription)
                .setAssetValue(assetValue)
                .setAssetQuantity(assetQuantity)
                .setAssetState(assetState)
                .build();
        return assetRegister;
    }
}






