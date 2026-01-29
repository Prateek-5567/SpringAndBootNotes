package com.Prateek.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean filtering() {
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("value1","value2","value3"),
							new SomeBean("value4","value5","value6")); 
	}
	
	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue filteringDynamic() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean); 		
		// to apply filtering you need to convert your normal object(someBean) into a mappingJacksonValue type object.
		// now you can do mappingJacksonValue.setFilters(filters) but just before that you need to define filters.
		
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter );       // FilterProvider further provides you with types of filterProviders
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-list-dynamic")
	public MappingJacksonValue filteringListDynamic() {
				
		List<SomeBean> asList = Arrays.asList(new SomeBean("value1","value2","value3"),
							new SomeBean("value4","value5","value6"));
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(asList);
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters =new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue; 
	}
	
	
	
}
