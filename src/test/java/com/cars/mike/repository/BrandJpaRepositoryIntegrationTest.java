package com.cars.mike.repository;

import com.cars.mike.model.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BrandJpaRepositoryIntegrationTest {

    @Autowired
    private BrandJpaRepository brandJpaRepository;

    @Test
    public void findOneByName() throws Exception {

        List<Brand> brandList = brandJpaRepository.findAll();
        assertThat(brandList.size(), is(greaterThanOrEqualTo(0)));

        Brand audiBrand = brandJpaRepository.findOneByName("AUDI");
        assertEquals("AUDI", audiBrand.getName());
    }

    @Test
    public void findByCreationDateBefore() throws Exception {

        Date searchBeforeDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("1956-01-01 00:00:00");
        Date expectedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("1955-01-01 00:00:00");

        List<Brand> brandList = brandJpaRepository.findByCreationDateBefore(searchBeforeDate);

        assertThat(brandList.size(), is(greaterThanOrEqualTo(1)));
        assertTrue("Dates aren't close enough to each other!", (expectedDate.getTime() - brandList.get(0).getCreationDate().getTime()) < 1000);
    }

    @Test
    public void findByCreationDateAfter() throws Exception {

        Date searchAftereDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2000-01-01 00:00:00");

        List<Brand> brandList = brandJpaRepository.findByCreationDateAfter(searchAftereDate);
        assertThat(brandList.size(), is(greaterThanOrEqualTo(1)));
        assertThat("MAZDA", is(brandList.get(0).getName()));

    }

    @Test
    public void findByActiveTrue() throws Exception {

        List<Brand> brandList = brandJpaRepository.findByActiveTrue();
        assertThat(brandList.size(), is(greaterThanOrEqualTo(5)));
    }

    @Test
    public void findByActiveFalse() throws Exception {

        List<Brand> brandList = brandJpaRepository.findByActiveFalse();
        assertThat(brandList.size(), is(greaterThanOrEqualTo(1)));
    }

    @Test
    public void testSaveAndGetAndDelete() throws Exception {

        Brand brand = new Brand();
        brand.setName("Test Brand");
        brand.setActive(false);
        brand.setCreationDate(new Date());
        brand.setYearlyTurnover(new BigDecimal(123456));

        brandJpaRepository.save(brand);

        Brand otherBrand = brandJpaRepository.findOne(brand.getId());
        assertThat("Test Brand", is(otherBrand.getName()));

        brandJpaRepository.delete(brand.getId());
        assertThat(null, is(brandJpaRepository.findOne(brand.getId())));


    }

}