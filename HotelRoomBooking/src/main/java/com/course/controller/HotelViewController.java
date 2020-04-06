package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.course.models.Hotel;
import com.course.services.HotelViewServices;


@Controller
@RequestMapping(value="/viewHotels")
public class HotelViewController {
	
	@Autowired
	@Qualifier("HotelViewServicesImpl")
	HotelViewServices HotelViewServicesImpl;

	//to get the data of the entire table
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotelList = null;
		hotelList = HotelViewServicesImpl.getAllDetails();
		if(hotelList != null)
		{
			return new ResponseEntity<List<Hotel>>(hotelList, HttpStatus.OK);
		}
		else
		{
			throw new RuntimeException("no hotels available");
		}
	}
	
	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAllCitites(){
		List<String> citiesList = null;
		citiesList = HotelViewServicesImpl.getCititesList();
		if(citiesList != null)
		{
			return new ResponseEntity<List<String>>(citiesList, HttpStatus.OK);
		}
		else
		{
			throw new RuntimeException("no hotels available");
		}
	}
	
	//to fetch the data on the bases of the city
	@RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
	public ResponseEntity<List<Hotel>> getLowCostHotels(@PathVariable("cityName")String City){
		List<Hotel> hotelList = null;
		hotelList = HotelViewServicesImpl.getLeastCostHotels(City);
		if(hotelList != null)
		{
			return new ResponseEntity<List<Hotel>>(hotelList, HttpStatus.OK);
		}
		else
		{
			throw new RuntimeException("no hotels available");
		}
	}	
	
	//to fetch only the hotel list on the bases of the city
	@RequestMapping(value = "/hotelList/{cityName}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getHotelList(@PathVariable("cityName")String City){
		List<String> listOfHotels = null;
		listOfHotels = HotelViewServicesImpl.getHotelsList(City);
		if(listOfHotels != null)
		{
			return new ResponseEntity<List<String>>(listOfHotels, HttpStatus.OK);
		}
		else
		{
			throw new RuntimeException("no hotels available");
		}
	}

}
