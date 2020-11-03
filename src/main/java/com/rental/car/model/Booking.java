package com.rental.car.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_booking")
	private Long idBooking;

	@Temporal(TemporalType.DATE)
	@Column(name="start_booking")
	private Date startBooking;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end_of_booking")
	private Date endOfBooking;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_user")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_car")
	private Car car;

	public Booking() {
		super();
	}
	
	public Booking(Date startBooking, Date endOfBooking, User user, Car car) {
		this.startBooking = startBooking;
		this.endOfBooking = endOfBooking;
		this.user = user;
		this.car = car;
	}

	public Long getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(Long idBooking) {
		this.idBooking = idBooking;
	}

	public Date getStartBooking() {
		return startBooking;
	}

	public void setStartBooking(Date startBooking) {
		this.startBooking = startBooking;
	}

	public Date getEndOfBooking() {
		return endOfBooking;
	}

	public void setEndOfBooking(Date endOfBooking) {
		this.endOfBooking = endOfBooking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
