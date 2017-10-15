package com.example.demo.Services.AllServices.Impl;

import com.example.demo.Domain.AssetRegister;
import com.example.demo.Repository.AssetRegisterRepository;
import com.example.demo.Services.AllServices.AssetRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Adeebo on 2017/08/26.
 */
@Component
public class AssetRegisterImpl implements AssetRegisterService {

    @Autowired
    AssetRegisterRepository assetRegisterRepository;

    @Override
    public AssetRegister save(AssetRegister entity) {
        return assetRegisterRepository.save(entity);
    }

    @Override
    public AssetRegister findById(Integer s) {
        return assetRegisterRepository.findOne(s);
    }

    @Override
    public AssetRegister update(Integer s) {
        return null;
    }

}
