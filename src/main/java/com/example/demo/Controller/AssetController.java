package com.example.demo.Controller;

import com.example.demo.Domain.AssetRegister;
import com.example.demo.Factory.AssetRegisterFactory;
import com.example.demo.Repository.AssetRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Adeebo on 2017/09/06.
 */
@Controller    // This means that this class is a Controller
@RequestMapping(path="/assetController")
public class AssetController {

    @Autowired
    private AssetRegisterRepository assetRegisterRepository;

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Add assets
    @GetMapping(path = "/addNewAsset") // Map ONLY GET Requests
    public
    @ResponseBody
    String addNewAsset(@DateTimeFormat(pattern="MMddyyyy") Date date, @RequestParam String assetName, @RequestParam String assetDescription, @RequestParam float assetValue, @RequestParam int assetQuantity, @RequestParam String assetState) {

        AssetRegister ar = AssetRegisterFactory.buildAssetRegister(date, assetName, assetDescription, assetValue, assetQuantity, assetState);

        assetRegisterRepository.save(ar);
        return "Asset Record Saved";
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Update services
    @GetMapping(path = "/updateAsset") // Map ONLY GET Requests
    public
    @ResponseBody
    String updateAsset(@RequestParam Integer assetID,@RequestParam Date date,@RequestParam String assetName,@RequestParam String assetDescription,@RequestParam float assetValue,@RequestParam int assetQuantity,@RequestParam String assetState) {

        AssetRegister ar = assetRegisterRepository.findOne(assetID);

        if (ar != null) {

            AssetRegister assetUpdate = new AssetRegister.Builder()
                    .copy(ar)
                    .setDate(date)
                    .setAssetName(assetName)
                    .setAssetDescription(assetDescription)
                    .setAssetValue(assetValue)
                    .setAssetQuantity(assetQuantity)
                    .setAssetState(assetState)
                    .build();
            assetRegisterRepository.save(assetUpdate);

            return "AssetRegister Record updated";

        } else

            return "AssetRegister not updated!";
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Search services
    @GetMapping(path = "/allAssets")
    public
    @ResponseBody
    Iterable<AssetRegister> getAllAssets() {

        return assetRegisterRepository.findAll();
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Delete services
    @GetMapping(path = "/deleteAssets")
    public
    @ResponseBody
    String deleteAdmin(@RequestParam Integer clubID) {

        AssetRegister assetDelete = assetRegisterRepository.findOne(clubID);

        if (assetDelete != null) {
            AssetRegister adminUpdate = new AssetRegister.Builder()
                    .copy(assetDelete)
                    .setAssetState("inactive")
                    .build();

            assetRegisterRepository.save(adminUpdate); //Records are not deleted. They are set to inactive

            return "Deleted " +  assetDelete.getAssetQuantity() + "x " +  assetDelete.getAssetName().toUpperCase() + " items";

        } else

            return "No Assets to delete";
    }
}
