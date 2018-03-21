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
        if(filterCriteria.getLengthOfStay()!=null && filterCriteria.getLengthOfStay()<=0){
            errors.rejectValue("lengthOfStay",null,"Length of stay shouldn't be less than 0");
        }

        if(filterCriteria.getMinStarRating()!=null  && filterCriteria.getMaxStarRating() !=null &&
                filterCriteria.getMinStarRating() > filterCriteria.getMaxStarRating()){
            errors.rejectValue("minStarRating", null,"Min star rating should be equal or higher than the max");
        }
        if(filterCriteria.getMinTotalPriceValue()!=null  && filterCriteria.getMaxTotalPriceValue() !=null &&
                filterCriteria.getMinTotalPriceValue() > filterCriteria.getMaxTotalPriceValue()){
            errors.rejectValue("minTotalPriceValue", null,"Min total price should be equal or higher than the max");
        }

        if(filterCriteria.getMinGuestRating()!=null && filterCriteria.getMaxGuestRating()!=null &&
                filterCriteria.getMinGuestRating() > filterCriteria.getMaxGuestRating()){
            errors.rejectValue("minGuestRating", null,"Min guest rating should be equal or higher Max");
        }
    }
}
