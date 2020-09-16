package com.testapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testapi.entity.City;
import com.testapi.model.CityModel;
import com.testapi.model.ResponseModel;
import com.testapi.service.CityService;

@RestController
public class CityRestController {
	
	
	private CityService cityService;

    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

	
	@RequestMapping(path = "city")
    public ResponseModel<List<CityModel>> getAllCity(){
        ResponseModel<List<CityModel>> result = new ResponseModel<>();
        List<CityModel> data = cityService.getAllCity();
        result.setData(data);
        result.setResponseCode(200);
        result.setResponseMessage("OK");

        return result;
    }
	
	@RequestMapping(path = "/country/{countryCode}")
    public ResponseModel<List<CityModel>> getByContryCode(@PathVariable("countryCode") String countryCode, HttpServletRequest request){
        String param = request.getRequestURI();

        System.out.println("param "+param);
        System.out.println("countryCode "+countryCode);

        ResponseModel<List<CityModel>> result = new ResponseModel<>();
        List<CityModel> data = cityService.getByContryCode(countryCode);
        result.setData(data);
        result.setResponseCode(200);
        result.setResponseMessage("OK");

        return result;
    }
	
	@RequestMapping(path = "/{startPopulation}/{endPopulation}")
	public ResponseModel<List<CityModel>> getByPopupation(@PathVariable("startPopulation") Integer startPopulation, @PathVariable ("endPopulation")Integer endPopulation, HttpServletRequest request){
		String param = request.getRequestURI();

        System.out.println("param "+param);
        System.out.println("countryCode "+startPopulation);
        System.out.println("countryCode "+endPopulation);
        
        ResponseModel<List<CityModel>> result = new ResponseModel<>();
        List<CityModel> data = cityService.getByPopupation(startPopulation, endPopulation);
        result.setData(data);
        result.setResponseCode(200);
        result.setResponseMessage("OK");

        return result;
	}
	
	@RequestMapping(path = "/name/{nameCity}")
    public ResponseModel<List<CityModel>> getByName(@PathVariable("nameCity") String name, HttpServletRequest request){
        String param = request.getRequestURI();

        System.out.println("param "+param);
        System.out.println("nameCity "+name);

        ResponseModel<List<CityModel>> result = new ResponseModel<>();
        List<CityModel> data = cityService.getByName(name);
        result.setData(data);
        result.setResponseCode(200);
        result.setResponseMessage("OK");

        return result;
    }
   
}
