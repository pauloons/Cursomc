package com.alexandre.cursos.services.exeptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class StandartError implements Serializable {

	private static final long serialVersionUID = 1L;

	private int Status;
	private String msg;
	private Long timeStemp;

	public StandartError(int status, String msg, Long timeStemp) {
		super();
		Status = status;
		this.msg = msg;
		this.timeStemp = timeStemp;
	}


	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStemp() {
		return timeStemp;
	}

	public void setTimeStemp(Long timeStemp) {
		this.timeStemp = timeStemp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
