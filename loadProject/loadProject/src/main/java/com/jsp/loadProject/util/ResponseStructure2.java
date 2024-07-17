package com.jsp.loadProject.util;

import java.util.List;

import lombok.Data;

@Data
public class ResponseStructure2<T> {
private List<T> payload;
private String response;
private int status;
}
