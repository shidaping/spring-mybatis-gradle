package com.sdp.mybatis.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
	long id;
	String name;
	int company;
	int engine;
	int theme;
	int method;
	int dimension;
//	List<GameImg> imgList;
	
}
