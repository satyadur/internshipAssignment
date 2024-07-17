package com.jsp.loadProject.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T payload;
	private String response;
	private int status;

}
