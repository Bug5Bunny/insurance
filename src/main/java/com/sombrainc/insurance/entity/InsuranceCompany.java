package com.sombrainc.insurance.entity;

public class InsuranceCompany {

	private String companyName;
	private String address;
	private String city;
	private String phone;

	public InsuranceCompany(String companyName, String address, String city, String phone) {
		super();
		this.companyName = companyName;
		this.address = address;
		this.city = city;
		this.phone = phone;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "InsuranceCompany [companyName=" + companyName + ", address=" + address + ", city=" + city + ", phone="
				+ phone + "]";
	}

	
}
