package com.cars.mike.repository;

import com.cars.mike.model.ModelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModelTypeJpaRepository extends JpaRepository<ModelType, Long> {

}
