package com.jorddin.web.controller;

import javax.validation.Valid;
import com.jorddin.domain.jsontemplates.OffersObj;
import com.jorddin.service.FilterToUriComponentService;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by Aladdin on 3/16/2018.
 *
 * This controller will handle the requests to show/filter hotels offers
 */
@Controller
public class HotelsController {

    @Autowired
    FilterCriteriaValidation filterCriteriaValidation;

    @Autowired
    FilterToUriComponentService filterToUriComponentService;
    private String JSON_CONSUMER_ROOT = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
    @RequestMapping(path = "/",method= RequestMethod.GET)

    /**
     * The handler is responsible to handle home page requests
     */
    public String home(Model model){

      RestTemplate restTemplate = new RestTemplate();
      OffersObj offersObj = restTemplate.getForObject(JSON_CONSUMER_ROOT,OffersObj.class);
      FilterCriteria filterCriteria = new FilterCriteria();
      model.addAttribute("offersObj",offersObj).addAttribute("filterCriteria",filterCriteria);
      return "index";
    }

    /**
     * This handler will validate the passed command object, convert its value to URI to consume json service
     * @param filterCriteria the command object
     * @param result validation result
     * @param model the attribute mapping
     * @return the view name
     */
    @RequestMapping(path = "/search")
    public String searchOffer(@ModelAttribute FilterCriteria filterCriteria, BindingResult result, Model model){
        if (result.hasErrors()){
            return "index";
        }
        URI cretiriaURI = populateCrateria(filterCriteria,model);
        RestTemplate restTemplate = new RestTemplate();
        OffersObj offersObj = restTemplate.getForObject(cretiriaURI,OffersObj.class);
        return "index";
    }


    /**
     * This method populates a passed map of members of FilterCriteria in order to construct a URI to consume the json service
     * @param filterCriteria the command object
     * @param map the map to be used to populate the data
     * @return the constructed URI pattern
     */
   public URI populateCrateria(FilterCriteria filterCriteria,Model map){
       Map <String,Object> mappedComponenets = filterToUriComponentService.mappedComponents(filterCriteria);
       URIBuilder uriBuilder=null;
       try {
           uriBuilder = new URIBuilder(JSON_CONSUMER_ROOT);

           for (Map.Entry<String, Object> entry : mappedComponenets.entrySet()) {
               uriBuilder.addParameter(entry.getKey(), entry.getValue().toString());
           }
          return uriBuilder.build();
       }
       catch (URISyntaxException ex){
           Logger.getLogger(Controller.class).error("Can't construct URI");
           return null;
       }
    }

    /**
     * Add a validation class to @{@link FilterCriteria} command object
     * @param binder the binder of the annotated component
     */
    @InitBinder("filterCriteria")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(filterCriteriaValidation);
    }
}