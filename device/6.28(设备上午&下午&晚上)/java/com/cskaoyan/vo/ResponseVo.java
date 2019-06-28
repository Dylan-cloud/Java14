package com.cskaoyan.vo;

/**
 * Created by little Stone
 * Date 2019/6/27 Time 10:23
 */
public class ResponseVo<T> {
    int Status;
	int errorNo;
	String message;
	T data;

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(int errorNo) {
		this.errorNo = errorNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
