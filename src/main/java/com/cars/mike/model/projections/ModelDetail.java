package com.cars.mike.model.projections;

import com.cars.mike.model.Brand;
import com.cars.mike.model.Model;
import com.cars.mike.model.ModelType;
//import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

//@Projection(name = "carModelDetail", types = {Model.class})
public interface ModelDetail {

    String getName();
    BigDecimal getPrice();
    Brand getBrand();
    ModelType getModelType();
    Short getSpeed();
    String getEngineType();
}
