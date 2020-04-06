package com.course.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.course.dao.HotelViewDao;
import com.course.dao.RoomBookingDao;
import com.course.models.RoomReservation;
import com.course.services.RoomBookingServices;

@Component(value = "RoomBookingServiceImpl")
public class RoomBookingServiceImpl implements RoomBookingServices {

	@Autowired
	private HotelViewDao hotelViewDao;
	
	@Autowired
	private RoomBookingDao roomBookingDao;
	
	int getTheTotalBookedRooms(Date CInDate, Date COutDate,String hotelName)
	{
		List<RoomReservation> roomList= roomBookingDao.findByCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqualAndHotelNameEquals(CInDate, COutDate, hotelName);
		int bookedRooms = 0;
		if(roomList != null)
		{
			for(RoomReservation room:roomList)
			{
				bookedRooms += room.getNoOfRoomsBooked();
			}
		}
		return bookedRooms;
		
	}

	@Override
	public int numberOfRoomsAvailable(RoomReservation roomReservation) {

		int bookedRooms = getTheTotalBookedRooms(roomReservation.getCheckOutDate(),roomReservation.getCheckInDate(),roomReservation.getHotelName());
		int totalRooms = hotelViewDao.getTotalRooms(roomReservation.getHotelName());
		int availableRooms = totalRooms-bookedRooms;
		System.out.println(" total rooms = "+totalRooms+" bookedRooms = "+bookedRooms);
		System.out.println("available rooms = "+availableRooms);
		return availableRooms;
	}

	@Override
	public void saveReservation(RoomReservation roomReservation) {

		roomBookingDao.save(roomReservation);		
	}
}
