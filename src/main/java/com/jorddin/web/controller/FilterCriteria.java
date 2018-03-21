package com.jorddin.web.controller;


import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aladdin on 3/17/2018.
 *
 * This class represents spring command object that will control the returned data from filtering process.
 * Any filtering criteria should be added here with its corresponding view.
 * Note that the date objects members are mapped from httpstring date value
 * The getters and setters are self-explaining
 *
 */

public class FilterCriteria {
    private String destinationName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minTripStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxTripStartDate;
    private Integer lengthOfStay;
    private Integer minStarRating;
    private Integer maxStarRating;
    private Integer minTotalPriceValue;
    private Integer maxTotalPriceValue;
    private Integer minGuestRating;
    private Integer maxGuestRating;

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Date getMinTripStartDate() {
        return minTripStartDate;
    }

    public void setMinTripStartDate(Date minTripStartDate) throws ParseException{
        this.minTripStartDate = minTripStartDate;
    }

    public Date getMaxTripStartDate() {
        return maxTripStartDate;
    }

    public void setMaxTripStartDate(Date maxTripStartDate) throws  ParseException{
        this.maxTripStartDate = maxTripStartDate;
    }

    public Integer getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(Integer lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public Integer getMinStarRating() {
        return minStarRating;
    }

    public void setMinStarRating(Integer minStarRating) {
        this.minStarRating = minStarRating;
    }

    public Integer getMaxStarRating() {
        return maxStarRating;
    }

    public void setMaxStarRating(Integer maxStarRating) {
        this.maxStarRating = maxStarRating;
    }

    public Integer getMinTotalPriceValue() {
        return minTotalPriceValue;
    }

    public void setMinTotalPriceValue(Integer minTotalPriceValue) {
        this.minTotalPriceValue = minTotalPriceValue;
    }

    public Integer getMaxTotalPriceValue() {
        return maxTotalPriceValue;
    }

    public void setMaxTotalPriceValue(Integer maxTotalPriceValue) {
        this.maxTotalPriceValue = maxTotalPriceValue;
    }

    public Integer getMinGuestRating() {
        return minGuestRating;
    }

    public void setMinGuestRating(Integer minGuestRating) {
        this.minGuestRating = minGuestRating;
    }

    public Integer getMaxGuestRating() {
        return maxGuestRating;
    }

    public void setMaxGuestRating(Integer maxGuestRating) {
        this.maxGuestRating = maxGuestRating;
    }
    private static Date convertToDate(String str)throws ParseException{
        DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
        return dateFormat.parse(str);
    }
}
