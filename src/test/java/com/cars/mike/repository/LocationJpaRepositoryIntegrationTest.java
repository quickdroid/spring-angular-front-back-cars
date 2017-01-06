package com.cars.mike.repository;

import com.cars.mike.model.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LocationJpaRepositoryIntegrationTest {

    @Autowired
    private LocationJpaRepository locationJpaRepository;

    @Test
    public void findFirstByStateIgnoreCase() throws Exception {

        Location location = locationJpaRepository.findFirstByStateIgnoreCase("texas");

        assertNotNull("State 'texas' Not Found", location);
        assertThat("37449", is(location.getPostCode()));
    }

    @Test
    public void findByStateNotLike() throws Exception {

        List<Location> locationList = locationJpaRepository.findByStateNotLike("Washington");

        assertNotNull(locationList);
        assertThat(locationList.size(), is(49));
    }

    @Test
    public void findByStateOrCountryOrPostCode() throws Exception {

        List<Location> locationList = locationJpaRepository.findByStateOrCountryOrPostCode("XXXX", "XXXX", "31749");

        assertThat(locationList.get(0), is(notNullValue()));
        assertThat("Virginia", is(locationList.get(0).getState()));

        locationList = locationJpaRepository.findByStateOrCountryOrPostCode("New York", "XXXX", "XXXX");

        assertThat(locationList.get(0), is(notNullValue()));
        assertThat("13347", is(locationList.get(0).getPostCode()));

        locationList = locationJpaRepository.findByStateOrCountryOrPostCode("XXXX", "United States", "XXXX");
        assertThat(locationList.size(), is(greaterThanOrEqualTo(50)));
    }

    @Test
    public void findByStateAndCountry() throws Exception {

        List<Location> locationList = locationJpaRepository.findByStateAndCountry("South Dakota", "United States");

        assertThat(locationList.get(0), is(notNullValue()));
        assertThat("32849", is(locationList.get(0).getPostCode()));
    }

    @Test
    public void findByStateIgnoreCaseStartingWith() throws Exception {

        List<Location> locationList = locationJpaRepository.findByStateIgnoreCaseStartingWith("new");

        assertThat(locationList.get(0), is(notNullValue()));
        assertThat(locationList.size(), is(greaterThanOrEqualTo(4)));
    }

}