package com.kmunoz.epicskins;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kmunoz.epicskins.DB.AppDataBase;

@Entity(tableName = AppDataBase.SKIN_TABLE)
public class Skin {
    @PrimaryKey(autoGenerate = true)
    private int mSkinId;

    private String mName;
    private String mPictureLink;
    private String mRarity;
    private String mDescription;
    private double mPrice;

    public Skin(String name, String pictureLink, String rarity, String description, double price) {
        mName = name;
        mPictureLink = pictureLink;
        mRarity = rarity;
        mDescription = description;
        mPrice = price;
    }

    public int getSkinId() {
        return mSkinId;
    }

    public void setSkinId(int skinId) {
        mSkinId = skinId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPictureLink() {
        return mPictureLink;
    }

    public void setPictureLink(String pictureLink) {
        mPictureLink = pictureLink;
    }

    public String getRarity() {
        return mRarity;
    }

    public void setRarity(String rarity) {
        mRarity = rarity;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    @Override
    public String toString() {
        return "Skin{" +
                "mSkinId=" + mSkinId +
                ", mName='" + mName + '\'' +
                ", mPictureLink='" + mPictureLink + '\'' +
                ", mRarity='" + mRarity + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }
}
