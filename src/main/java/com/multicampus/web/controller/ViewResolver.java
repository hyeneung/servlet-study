package com.multicampus.web.controller;

import lombok.Setter;

@Setter
public class ViewResolver {
	private String prefix;
	private String suffix;
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
