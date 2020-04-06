package com.course.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.course.models.RoomReservation;
import com.course.services.RoomBookingServices;

@Controller
@RequestMapping(value="/booking")
public class RoomBookingController {
	
	@Autowired
	RoomBookingServices  RoomBookingServiceImpl;
	//to the data of the entire table
		@RequestMapping(value = "/saveReservation", method = RequestMethod.POST)
		//@RequestBody RoomReservation roomReservation
		public ResponseEntity<String> saveReservation(@RequestBody RoomReservation roomReservation){
			
			
			//RoomReservation roomReservation1 = new RoomReservation(9, "banglore", "venusHotel", new Date(), new Date(), 3);
			int availRooms = RoomBookingServiceImpl.numberOfRoomsAvailable(roomReservation);
			if(availRooms <=roomReservation.getNoOfRoomsBooked())
				return new ResponseEntity<String>("{\"result\": \"fail\"}", HttpStatus.OK);
			else				
			{
				RoomBookingServiceImpl.saveReservation(roomReservation);
				int id = roomReservation.getId();
				String uniqueId = roomReservation.getHotelName()+id;
				return new ResponseEntity<String>("{\"result\": \"success\",\"id\": \""+uniqueId+"\"}", HttpStatus.OK);
			}
		}
}
