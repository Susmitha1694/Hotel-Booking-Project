package com.course.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roomreservation",schema="hotelbooking_db")
public class RoomReservation {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="city")
	private String city;
	@Column(name="hotelname")
	private String hotelName;
	@Column(name="checkindate")
	private Date checkInDate;
	@Column(name="checkoutdate")
	private Date checkOutDate;
	@Column(name="noofroomsbooked")
	private int noOfRoomsBooked;
	@Column(name="totalamount")
	private int totalAmount;

	public RoomReservation() {
		super();
	}

	public RoomReservation(int id, String city, String hotelName, Date checkInDate, Date checkOutDate,
			int noOfRoomsBooked, int totalAmount) {
		super();
		this.id = id;
		this.city = city;
		this.hotelName = hotelName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.noOfRoomsBooked = noOfRoomsBooked;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getNoOfRoomsBooked() {
		return noOfRoomsBooked;
	}

	public void setNoOfRoomsBooked(int noOfRoomsBooked) {
		this.noOfRoomsBooked = noOfRoomsBooked;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}	
}
