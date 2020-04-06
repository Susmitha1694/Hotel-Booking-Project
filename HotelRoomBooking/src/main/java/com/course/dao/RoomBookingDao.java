package com.course.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.course.models.RoomReservation;

@Repository
public interface RoomBookingDao extends JpaRepository<RoomReservation , String>{
	
	/*@Query(value="select * from roomreservation rr where "
			+ "(rr.checkoutdate>=?1 and rr.checkindate<=?1) "
			+ "and (rr.checkoutdate>=?2 and rr.checkindate<=?2)",nativeQuery=true)
	int getTheTotalBookedRooms(Date CInDate, Date COutDate);*/
	List<RoomReservation> findByCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqualAndHotelNameEquals(Date checkOutDate,Date checkInDate,String hotelName);
}
