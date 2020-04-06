package com.course.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.course.models.Hotel;

@Repository
public interface HotelViewDao extends JpaRepository<Hotel , String> {
	
	List<Hotel> findAll();
	
	List<Hotel> findByHotelCityOrderByTariffPerRoomAsc(String hotelCity);
	
	@Query(value="select distinct hd.hotelcity from hoteldetails hd",nativeQuery=true)
	List<String> getAllCities();
			
	@Query(value = "select hdetails.hotelname from hoteldetails hdetails where hdetails.hotelcity =?1",nativeQuery=true)
	List<String> getListOfHotels(String hotelCity);	
	
	@Query(value = "select hdetails.hotelnoofrooms from hoteldetails hdetails where hdetails.hotelname=?1",nativeQuery=true)
	int getTotalRooms(String hotelName);
}
