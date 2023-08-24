package com.library.exception;

public enum ErrorCode {
	
	DATA_NOT_FOUND("001","Data IS not Available in Database"), INVALID_ID("002","Request id Does not Exist");
	
	private final String code;
	private final String message;
	  private ErrorCode(String code, String message) { this.code = code;
	  this.message = message; }
	 
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
}
