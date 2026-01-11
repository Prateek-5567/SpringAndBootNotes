package com.Prateek.learn_spring_framework.example.a2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService { 
	
	private dataService ds;
	
	@Autowired
	public BusinessCalculationService(@Qualifier("MongoDb") dataService ds) {
		super();
		this.ds=ds;
	} 
	
	public int findMax() {
		int[] temp = ds.retrieveData();
		return Arrays.stream(temp).max().orElse(0);
	}
}
