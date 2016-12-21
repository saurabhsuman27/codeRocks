package com.saurabh.fileProcessor;

public class MenuException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorCode;
	
	
	public MenuException(String errorMessage){
		super(errorMessage);
	}

	public MenuException(String errorCode, String errorMessage){
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage(){
		return this.errorMessage;
	}
	
	public String getErrorCode(){
		return this.errorCode;
	}
}
