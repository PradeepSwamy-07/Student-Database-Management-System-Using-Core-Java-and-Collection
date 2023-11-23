package com.jsp.customException;

public class StudentNotFoundException extends RuntimeException{
	private String Message;
	
	public StudentNotFoundException(String Message)
	{
		super();
		this.Message=Message;
	}
	@Override
	public String getMessage()
	{
		return Message;
	}
}
