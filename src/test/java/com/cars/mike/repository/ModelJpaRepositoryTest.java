package com.cars.mike.repository;

import com.cars.mike.model.Model;
import com.cars.mike.utils.ModelTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ModelJpaRepositoryTest {

    @Autowired
    private ModelJpaRepository modelJpaRepository;

    @Test
    public void findByPriceGreaterThanEqualAndPriceLessThanEqual() throws Exception {

        BigDecimal min = new BigDecimal(Double.toString(79999999));
        BigDecimal max = new BigDecimal(Double.toString(99999999));

        List<Model> modelList = modelJpaRepository.findByPriceGreaterThanEqualAndPriceLessThanEqual(min, max);

        System.out.println(modelList.toString());

        //assertThat((Collection)list, is(not(empty())));
        //assertThat(modelList.isEmpty(), is(false));
        assertThat(modelList, is(not(emptyCollectionOf(Model.class))));
        assertThat(modelList.size(), is(greaterThanOrEqualTo(2)));
    }

    @Test
    public void findBySpeedGreaterThanEqual() throws Exception {

        List<Model> modelList = modelJpaRepository.findBySpeedGreaterThanEqual((short) 246);

        assertThat(modelList, is(not(emptyCollectionOf(Model.class))));
        assertThat(modelList.size(), is(greaterThanOrEqualTo(1)));
        assertThat("BMV", is(modelList.get(0).getBrand().getName()));
    }

    @Test
    public void findByEngineType() throws Exception {

        List<Model> modelList = modelJpaRepository.findByEngineType("PETROL");

        assertThat(modelList, is(not(emptyCollectionOf(Model.class))));
        assertThat(modelList.size(), is(greaterThanOrEqualTo(2)));
        assertThat("BMW i8", anyOf(equalTo(modelList.get(0).getName()), equalTo(modelList.get(1).getName())));
    }

    @Test
    public void findByModelTypeNameIn() throws Exception {

        List<ModelTypeEnum> modelTypes = new ArrayList<>();
        modelTypes.add(ModelTypeEnum.COUPE);
        modelTypes.add(ModelTypeEnum.PICKUP);

        List<Model> modelList = modelJpaRepository.findByModelTypeNameIn(modelTypes);

        assertThat(modelList, is(not(emptyCollectionOf(Model.class))));
        assertThat(modelList.size(), is(greaterThanOrEqualTo(2)));

        modelList.forEach((model) -> {
            assertThat(ModelTypeEnum.COUPE, is(model.getModelType().getName()));
        });


    }

    @Test
    public void findByBrandIn() throws Exception {

        List<String> brandList = new ArrayList<>();
        brandList.add("AUDI");
        brandList.add("MAZDA");

        List<Model> modelList = modelJpaRepository.findByBrandNameIn(brandList);

        modelList.forEach((model) -> {
            assertTrue(model.getBrand().getName().equals("AUDI") ||
                       model.getBrand().getName().equals("MAZDA"));
        });

    }

}