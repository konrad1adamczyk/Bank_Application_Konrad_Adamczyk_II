package com.luxoft.bankapp.service;

public enum Gender
{
	MALE("Mr"), FEMALE("Ms");
	
	private String sex;
	
	Gender(String sex)
	{
		this.sex = sex;
	}
	
	public String getClientSalutation()
	{
		return sex;
	}

	
}
