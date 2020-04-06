package com.course.services;

import com.course.models.RoomReservation;

public interface RoomBookingServices {
	
	int numberOfRoomsAvailable(RoomReservation roomReservation);
	void saveReservation(RoomReservation roomReservation);
}
