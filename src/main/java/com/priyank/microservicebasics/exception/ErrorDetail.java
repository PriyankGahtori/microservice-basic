package com.priyank.microservicebasics.exception;

import java.util.Date;

public class ErrorDetail {

	String message;
	Date timeStamp;
	String detail;

	public ErrorDetail(String message, Date timeStamp, String detail) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
		this.detail = detail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
