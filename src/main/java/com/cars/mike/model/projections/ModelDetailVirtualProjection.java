package com.cars.mike.model.projections;


import com.cars.mike.model.Brand;
import com.cars.mike.model.Model;
import com.cars.mike.model.ModelType;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

//@Projection(name = "carModelDetailVirtualProjection", types = {Model.class})
public interface ModelDetailVirtualProjection {

    @Value("#{target.id}")
    Long getId();
    @Value("#{target.name}")
    String getName();
    @Value("#{target.price}")
    BigDecimal getPrice();
    Short getSpeed();
    String getEngineType();
    @Value("#{target.brand.name}")
    String getBrand();
    @Value("#{target.modelType.name}")
    String getModelType();



/*    @Value("#{target.modelType.name.split(' ')[0]} #{target.name}")
    String getFullName();*/



}
