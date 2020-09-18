package com.testapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testapi.entity.City;
import com.testapi.model.CityModel;
import com.testapi.repository.CityRepository;


@Service
public class CityService {
	 @Autowired 
	 private CityRepository cityRepository;


	
    public List<CityModel> getAllCity() {

        List<City> cityList = cityRepository.findAll();

        return transformEntityToModel(cityList);

    }
    
    public List<CityModel> getByContryCode(String countryCode) {

        List<City> cityList = cityRepository.findByCountryCode(countryCode);

        return transformEntityToModel(cityList);

    }
    public List<CityModel> getByName(String name) {

        List<City> cityList = cityRepository.findByName(name);

        return transformEntityToModel(cityList);

    }
    public List<CityModel> getByDistrict(String district) {

        List<City> cityList = cityRepository.findByDistrict(district);

        return transformEntityToModel(cityList);

    }
    
    public List<CityModel> getByPopupation(Integer startPopulation,Integer endPopulation){
    	List<City> cityList = cityRepository.findByPopulation(startPopulation, endPopulation);
    	return transformEntityToModel(cityList);
    }
    
    public List<CityModel> transformEntityToModel(List<City> cityList) {
        List<CityModel> cityModelList = new ArrayList<>();

        for (City c: cityList) {
            CityModel x = new CityModel();
            x.setCountryCode(c.getCountryCode());
            x.setDistrict(c.getDistrict());
            x.setId(c.getId());
            x.setName(c.getName());
            x.setPopulation(c.getPopulation());
            cityModelList.add(x);
        }

        return cityModelList;
    }
    
   
}
