package com.course.services;

import java.util.List;

import com.course.models.Hotel;

public interface HotelViewServices {

	List<Hotel> getLeastCostHotels(String City);
	List<Hotel> getAllDetails();
	List<String> getHotelsList(String city);
	List<String> getCititesList();
}
