package com.renato.cursomc.resources.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer statusHttp;
	private String msg;
	private Long timestamp;
	
	public StandardError(Integer statusHttp, String msg, Long timestamp) {
		super();
		this.statusHttp = statusHttp;
		this.msg = msg;
		this.timestamp = timestamp;
	}
	
	

}
