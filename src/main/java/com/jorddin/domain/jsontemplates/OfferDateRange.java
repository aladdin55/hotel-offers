
package com.jorddin.domain.jsontemplates;

import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.annotation.*;

/**
 * Java plain object of JSON object https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel
 * Generated via http://www.jsonschema2pojo.org/
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "travelStartDate",
    "travelEndDate",
    "lengthOfStay"
})
public class OfferDateRange {

    @JsonProperty("travelStartDate")
    private Date travelStartDate = null;
    @JsonProperty("travelEndDate")
    private Date travelEndDate = null;
    @JsonProperty("lengthOfStay")
    private Integer lengthOfStay;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("travelStartDate")
    public Date getTravelStartDate() {
        return travelStartDate;
    }

    @JsonSetter("travelStartDate")
    public void setTravelStartDate(List<Integer> travelStartDate) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR,travelStartDate.get(0));
        calendar.set(Calendar.MONTH,travelStartDate.get(1)+1);
        calendar.set(Calendar.DAY_OF_MONTH,travelStartDate.get(2));
        this.travelStartDate = calendar.getTime();
    }

    @JsonProperty("travelEndDate")
    public Date getTravelEndDate() {
        return travelEndDate;
    }

    @JsonSetter("travelEndDate")
    public void setTravelEndDate(List<Integer> travelEndDate) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR,travelEndDate.get(0));
        calendar.set(Calendar.MONTH,travelEndDate.get(1)+1);
        calendar.set(Calendar.DAY_OF_MONTH,travelEndDate.get(2));
        this.travelEndDate = calendar.getTime();
    }


    @JsonProperty("lengthOfStay")
    public Integer getLengthOfStay() {
        return lengthOfStay;
    }

    @JsonProperty("lengthOfStay")
    public void setLengthOfStay(Integer lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
