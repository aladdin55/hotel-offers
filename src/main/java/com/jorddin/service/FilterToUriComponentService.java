package com.jorddin.service;

import com.jorddin.web.controller.FilterCriteria;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aladdin on 3/18/2018.
 */
@Component
public class FilterToUriComponentService {
    public final static DateFormat API_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public Map<String,Object> mappedComponents(@NonNull FilterCriteria filterCriteria){
        Map<String,Object> map = new HashMap<String,Object>();
        if(!ObjectUtils.isEmpty(filterCriteria.getDestinationName())){
            map.put("destinationName",filterCriteria.getDestinationName());
        }
        if(filterCriteria.getMinTripStartDate()!=null){
            map.put("minTripStartDate",API_DATE_FORMAT.format(filterCriteria.getMinTripStartDate()));
        }
        if(filterCriteria.getMaxTripStartDate()!=null){
            map.put("maxTripStartDate",API_DATE_FORMAT.format(filterCriteria.getMaxTripStartDate()));
        }
        if(filterCriteria.getLengthOfStay()!=null){
            map.put("lengthOfStay",filterCriteria.getLengthOfStay());
        }
        if(filterCriteria.getMinStarRating()!=null){
            map.put("minStarRating",filterCriteria.getMinStarRating());
        }
        if(filterCriteria.getMaxStarRating()!=null){
            map.put("maxStarRating",filterCriteria.getMaxStarRating());
        }
        if(filterCriteria.getMinTotalPriceValue()!=null){
            map.put("minTotalRate",filterCriteria.getMinTotalPriceValue());
        }
        if(filterCriteria.getMaxTotalPriceValue()!=null){
            map.put("minTotalRate",filterCriteria.getMaxTotalPriceValue());
        }
        if(filterCriteria.getMinGuestRating()!=null){
            map.put("minGuestRating",filterCriteria.getMinGuestRating());
        }
        if(filterCriteria.getMaxGuestRating()!=null){
            map.put("maxGuestRating",filterCriteria.getMaxGuestRating());
        }
        return map;
    }
}
