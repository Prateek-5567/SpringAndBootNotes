package com.Prateek.learn_spring_boot_anotherEg;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllerClass {
	
	@RequestMapping("FalanaApi")
	public List<DataAsObject> getData(){
		return Arrays.asList(
					new DataAsObject(1,"Learn DSA","Striver"),
					new DataAsObject(2,"Learn frontEnd","HiteshChoudhary")
				);
	} // return List of objects.
}
