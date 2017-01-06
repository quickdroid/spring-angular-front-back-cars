package com.cars.mike.repository;

import com.cars.mike.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {

    Location findFirstByStateIgnoreCase(String state);

    List<Location> findByStateNotLike(String state);

    List<Location> findByStateOrCountryOrPostCode(String state, String country, String postCode);

    List<Location> findByStateAndCountry(String state, String country);

    List<Location> findByStateIgnoreCaseStartingWith(String state);

}
