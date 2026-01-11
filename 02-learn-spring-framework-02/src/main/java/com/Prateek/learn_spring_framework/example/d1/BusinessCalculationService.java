package com.Prateek.learn_spring_framework.example.d1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service  			// : indicates that this Component contains some Buisness(main) logic
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
