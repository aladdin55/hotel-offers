package com.jorddin.web.controller;


import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Aladdin on 3/18/2018.
 *
 * A spring components to validate @{@link FilterCriteria} object
 */
@Component
public class FilterCriteriaValidation implements Validator {

    /**
     * returns the class that this validation is supposed to validate
     * @param clazz the validated class
     * @return true if the validation is applicable
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(FilterCriteria.class);
    }


    /**
     * The class try to validate the command object data, it will add a corresponding error message according to the problematic
     * field
     * @param target the command object
     * @param errors the errors encountered during the validation
     */
    @Override
    public void validate(@Nullable Object target, Errors errors) {
        FilterCriteria filterCriteria = (FilterCriteria) target;

        if(filterCriteria.getMinTripStartDate()!=null && filterCriteria.getMaxTripStartDate()!=null
                && filterCriteria.getMinTripStartDate().compareTo(filterCriteria.getMaxTripStartDate())>0){
            errors.rejectValue("minTripStartDate",null,"Min Trip start date should be less than the max");
        }
        if(filterCriteria.getLengthOfStay()!=null && filterCriteria.getLengthOfStay()<1){
            errors.rejectValue("lengthOfStay",null,"Length of stay shouldn't be less than 1");
        }

        if(filterCriteria.getMinStarRating()!=null ){
            if(filterCriteria.getMinStarRating() < 1){
                errors.rejectValue("minStarRating",null,"Min star can't be less than 1");
            }
            if(filterCriteria.getMaxStarRating()!=null && filterCriteria.getMaxStarRating() < filterCriteria.getMinStarRating()){
                errors.rejectValue("minStarRating", null,"Min star rating should be equal or higher than the max");
            }
        }
        if(filterCriteria.getMaxStarRating()!=null && filterCriteria.getMaxStarRating() < 1 ){
            errors.rejectValue("maxStarRating",null,"Max star can't be less than 1");
        }
        if(filterCriteria.getMinTotalPriceValue()!=null ){
            if(filterCriteria.getMinTotalPriceValue() < 1){
                errors.rejectValue("minTotalPriceValue",null,"Min total can't be less than 1");
            }
            if(filterCriteria.getMaxTotalPriceValue()!=null && filterCriteria.getMaxTotalPriceValue() < filterCriteria.getMinTotalPriceValue()){
                errors.rejectValue("minTotalPriceValue", null,"Min total price should be equal or higher than the max");
            }
        }
        if(filterCriteria.getMaxTotalPriceValue()!=null && filterCriteria.getMaxTotalPriceValue() < 1 ){
            errors.rejectValue("maxTotalPriceValue",null,"Max total price can't be less than 1");
        }

        if(filterCriteria.getMinGuestRating()!=null ){
            if(filterCriteria.getMinGuestRating() < 1){
                errors.rejectValue("minGuestRating",null,"Min guest rating can't be less than 1");
            }
            if(filterCriteria.getMaxGuestRating()!=null && filterCriteria.getMaxGuestRating() < filterCriteria.getMinGuestRating()){
                errors.rejectValue("minGuestRating", null,"Min guest rating should be equal or higher than the max");
            }
        }
        if(filterCriteria.getMaxGuestRating()!=null && filterCriteria.getMaxGuestRating() < 1 ){
            errors.rejectValue("maxGuestRating",null,"Max guest rating can't be less than 1");
        }
    }
}
