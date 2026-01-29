package com.Prateek.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties( {"field1","field2"} )  : use it for multiple fields filtering.
//@JsonIgnoreProperties("field1")
@JsonFilter("someBeanFilter")      // this is used to link your Core class to dynamic filtering ; after this your FilterProvider gets access to the fields.
public class SomeBean {
	private String field1;
	
//	@JsonIgnore					// filter it out in JSON response i.e dont return - static filtering.
	private String field2;
	private String field3;
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	public String getField1() {
		return field1;
	}
	public String getField2() {
		return field2;
	}
	public String getField3() {
		return field3;
	}
	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
}
