package com.testapi.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testapi.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	 @Query("SELECT c FROM City c WHERE c.name LIKE ?1% ")
	  List<City> findByName(String name);
	 
	 @Query("SELECT c FROM City c WHERE c.district LIKE ?1% ")
	 List<City> findByDistrict(String district);
	 
	 @Query("SELECT c FROM City c WHERE c.population BETWEEN ?1 AND ?2 ")
	 List<City> findByPopulation(Integer startPopulation,Integer endPopulation);
	 
	  List<City> findByCountryCode(String countryCode);
    
    
   
   
}
