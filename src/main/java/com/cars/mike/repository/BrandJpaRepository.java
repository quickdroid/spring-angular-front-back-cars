package com.cars.mike.repository;

import com.cars.mike.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
//@RepositoryRestResource(path = "mark")
public interface BrandJpaRepository extends JpaRepository<Brand, Long> {

    Brand findOneByName(String name);

    List<Brand> findByCreationDateBefore(Date foundedDate);
    List<Brand> findByCreationDateAfter(Date foundedDate);

    List<Brand> findByActiveTrue();
    List<Brand> findByActiveFalse();
}
