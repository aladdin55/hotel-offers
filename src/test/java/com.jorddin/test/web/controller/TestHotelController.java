package com.jorddin.test.web.controller;

import com.jorddin.domain.jsontemplates.OffersObj;
import com.jorddin.web.WebConfiguration;
import com.jorddin.web.controller.FilterCriteria;
import com.jorddin.web.controller.HotelController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
/**
 * Created by Aladdin on 3/22/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfiguration.class)
@WebAppConfiguration

public class TestHotelController {


    private MockMvc mockMvc;

    @Autowired
    private HotelController hotelController;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(hotelController)
                .build();
    }
    @Test
    public void sanityCheckHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()).andExpect(forwardedUrl("index"))
                .andExpect(model().attribute("filterCriteria",instanceOf(FilterCriteria.class)));
    }
    @Test
    public void sanityCheckSeach() throws Exception {
        mockMvc.perform(get("/search").param("destinationName","New Orleans"))
                .andExpect(status().isOk()).andExpect(forwardedUrl("index"))
                .andExpect(model().attribute("offersObj",
                        hasProperty("offers",hasProperty("hotel",everyItem(hasProperty("destination",hasProperty("shortName",is("New Orleans"))))))));
    }
}
