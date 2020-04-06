package com.course.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.course.dao.HotelViewDao;
import com.course.models.Hotel;
import com.course.services.HotelViewServices;

@Component(value="HotelViewServicesImpl")
public class HotelViewServicesImpl implements HotelViewServices{

	@Autowired
	private HotelViewDao hotelViewDao;
	
	@Override
	public List<Hotel> getLeastCostHotels(String City) {

		return hotelViewDao.findByHotelCityOrderByTariffPerRoomAsc(City);
	}

	@Override
	public List<String> getHotelsList(String city) {

		return hotelViewDao.getListOfHotels(city);
	}

	@Override
	public List<Hotel> getAllDetails() {

		return hotelViewDao.findAll();
	}

	@Override
	public List<String> getCititesList() {

		return hotelViewDao.getAllCities();
	}		
}
