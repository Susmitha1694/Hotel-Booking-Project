package com.course.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hoteldetails",schema="hotelbooking_db")
public class Hotel {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="hotelname")
	private String hotelName;
	@Column(name="hotelcity")
	private String hotelCity;
	@Column(name="hotelnoofrooms")
	private int hotelNoOfRooms;
	@Column(name="hotelstarrating")
	private int hotelStarRating;
	@Column(name="tariffperroom")
	private double tariffPerRoom;
	public Hotel() {
		super();
	}
	public Hotel(int id, String hotelName, String hotelCity, int hotelNoOfRooms, int hotelStarRating,
			double tariffPerRoom) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.hotelCity = hotelCity;
		this.hotelNoOfRooms = hotelNoOfRooms;
		this.hotelStarRating = hotelStarRating;
		this.tariffPerRoom = tariffPerRoom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelCity() {
		return hotelCity;
	}
	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}
	public int getHotelNoOfRooms() {
		return hotelNoOfRooms;
	}
	public void setHotelNoOfRooms(int hotelNoOfRooms) {
		this.hotelNoOfRooms = hotelNoOfRooms;
	}
	public int getHotelStarRating() {
		return hotelStarRating;
	}
	public void setHotelStarRating(int hotelStarRating) {
		this.hotelStarRating = hotelStarRating;
	}
	public double getTrariffPerRoom() {
		return tariffPerRoom;
	}
	public void setTrariffPerRoom(double tariffPerRoom) {
		this.tariffPerRoom = tariffPerRoom;
	}		
}
