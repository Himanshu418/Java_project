package com.amdocs.pojos.exception;

public class DoctorNotFoundException extends Exception{
	
	/**
	 * 
	 */
	
	private String message;
	
	public DoctorNotFoundException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "DoctorNotFoundException [message=" + message + "]";
	}
	
}
