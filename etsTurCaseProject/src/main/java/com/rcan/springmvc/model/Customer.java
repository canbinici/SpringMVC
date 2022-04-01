package com.rcan.springmvc.model;

public class Customer {

	private Integer id;
	private String name;
	private String surname;
	private String blood;
	private String phone;
	private String address;

	public Customer(Integer id, String name, String surname, String blood, String phone, String address) {

		this(name, surname, blood, phone, address);
		this.id = id;

	}
	
	public Customer() {
		
	}
	public Customer(String name, String surname, String blood, String phone, String address) {
		super();
		this.name = name;
		this.surname = surname;
		this.blood = blood;
		this.phone = phone;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", blood=" + blood + ", phone="
				+ phone + ", address=" + address + "]";
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
