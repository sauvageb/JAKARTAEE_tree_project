package com.example.treeproject.web.model;

import com.example.treeproject.api.dto.TreeDTO;

public class Tree {

    private long id;

    private String name;
    private String family;

    private String pictureUrl;

    private boolean isEdible;

    private double latitude;

    private double longitude;

    public Tree() {
    }

    public Tree(String name, String family, String pictureUrl, boolean isEdible, double latitude, double longitude) {
        this.name = name;
        this.family = family;
        this.pictureUrl = pictureUrl;
        this.isEdible = isEdible;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Tree(long id, String name, String family, String pictureUrl, boolean isEdible, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.pictureUrl = pictureUrl;
        this.isEdible = isEdible;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public TreeDTO toDTO() {
        TreeDTO dto = new TreeDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setFamily(this.family);
        dto.setEdible(this.isEdible);
        dto.setLatitude(this.latitude);
        dto.setLongitude(this.longitude);
        return dto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return isEdible;
    }

    public void setEdible(boolean edible) {
        isEdible = edible;
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
