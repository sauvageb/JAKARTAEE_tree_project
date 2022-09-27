package com.example.treeproject.api.dto;

import com.example.treeproject.web.model.Tree;

public class CreateUpdateTree {

    private String name;
    private String family;
    private boolean edible;
    private double latitude;
    private double longitude;

    private String pictureUrl;

    public CreateUpdateTree() {
    }

    public Tree toTree() {
        return new Tree(
                this.name,
                this.family,
                this.pictureUrl,
                this.edible,
                this.latitude,
                this.longitude
        );
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
