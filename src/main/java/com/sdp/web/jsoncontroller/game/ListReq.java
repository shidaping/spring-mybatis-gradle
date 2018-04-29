package com.sdp.web.jsoncontroller.game;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListReq{
	String name;
	int company;
	int engine;
	int method;
	int dimension;
	int theme;
	Date minTime;
	Date maxTime;
	int page;
	int pageSize;
	
}