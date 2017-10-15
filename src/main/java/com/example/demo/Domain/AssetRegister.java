package com.example.demo.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Adeebo on 2017/08/06.
 */
@Entity
public class AssetRegister implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String assetID;
    private Date date;
    private String assetName;
    private String assetDescription;
    private float assetValue;
    private int assetQuantity;
    private String assetState;

    public AssetRegister() {
    }

    public AssetRegister(Builder builder){

        this.assetID = builder.assetID;
        this.date = builder.date;
        this.assetName = builder.assetName;
        this.assetDescription = builder.assetDescription;
        this.assetValue = builder.assetValue;
        this.assetQuantity = builder.assetQuantity;
        this.assetState = builder.assetState;
    }

    public static class Builder {

        private String assetID;
        private Date date;
        private String assetName;
        private String assetDescription;
        private float assetValue;
        private int assetQuantity;
        private String assetState;

        public Builder setAssetID(String assetID) {
            this.assetID = assetID;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setAssetName(String assetName) {
            this.assetName = assetName;
            return this;
        }

        public Builder setAssetDescription(String assetDescription) {
            this.assetDescription = assetDescription;
            return this;
        }

        public Builder setAssetValue(float assetValue) {
            this.assetValue = assetValue;
            return this;
        }

        public Builder setAssetQuantity(int assetQuantity) {
            this.assetQuantity = assetQuantity;
            return this;
        }

        public Builder setAssetState(String assetState) {
            this.assetState = assetState;
            return this;
        }

        public Builder copy (AssetRegister value){

            this.assetID = value.assetID;
            this.date = value.date;
            this.assetName = value.assetName;
            this.assetDescription = value.assetDescription;
            this.assetValue = value.assetValue;
            this.assetQuantity = value.assetQuantity;
            this.assetState = value.assetState;
            return this;
        }

        public AssetRegister build(){

            return new AssetRegister(this);
        }
    }

    public String getAssetID() {
        return assetID;
    }

    public Date getDate() {
        return date;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetDescription() {
        return assetDescription;
    }

    public float getAssetValue() {
        return assetValue;
    }

    public int getAssetQuantity() {
        return assetQuantity;
    }

    public String getAssetState() {
        return assetState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssetRegister)) return false;

        AssetRegister that = (AssetRegister) o;

        return assetID.equals(that.assetID);

    }

    @Override
    public int hashCode() {
        return assetID.hashCode();
    }

    @Override
    public String toString() {
        return "AssetRegister{" +
                "assetID='" + assetID + '\'' +
                ", date=" + date +
                ", assetName='" + assetName + '\'' +
                ", assetDescription='" + assetDescription + '\'' +
                ", assetValue=" + assetValue +
                ", assetQuantity=" + assetQuantity +
                ", assetState='" + assetState + '\'' +
                '}';
    }
}
