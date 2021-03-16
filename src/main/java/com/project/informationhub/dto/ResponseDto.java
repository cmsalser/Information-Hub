package com.project.informationhub.dto;

public class ResponseDto {
	private String message;
	private int code;
	private String status;
	private Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseDto [message=" + message + ", code=" + code + ", status=" + status + ", data=" + data + "]";
	}
	
	
}
