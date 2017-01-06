package com.cars.mike.repository;

import com.cars.mike.model.Model;
import com.cars.mike.model.projections.ModelDetailVirtualProjection;
import com.cars.mike.utils.ModelTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.config.Projection;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


//@RepositoryRestResource(excerptProjection = ModelDetailVirtualProjection.class)
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@Repository
public interface ModelJpaRepository extends JpaRepository<Model, Long> {

    List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal lowest, BigDecimal price);

    List<Model> findBySpeedGreaterThanEqual(short speed);

    List<Model> findByEngineType(String engineType);

    List<Model> findByModelTypeNameIn(List<ModelTypeEnum> types);

    List<Model> findByBrandNameIn(List<String> brands);
}
