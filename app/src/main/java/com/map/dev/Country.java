package com.map.dev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by map on 2016/8/12.
 */
public class Country {
    private String country;
    private int id;
    private boolean isChecked;
    private List<City> cityList = new ArrayList<>();

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
