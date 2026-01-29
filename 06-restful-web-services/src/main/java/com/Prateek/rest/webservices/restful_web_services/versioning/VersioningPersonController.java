package com.Prateek.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	// uri versioning	
		@RequestMapping(value="/v1/person",method=RequestMethod.GET)
		public PersonV1 getV1PersonUri() {
			return new PersonV1("Bob Charlie");
		}
	// uri versioning		
		@GetMapping(path="/v2/person")
		public PersonV2 getV2PersonUri() {
			return new PersonV2(new Name("Nicholas","Henderson"));
		}
		
	// RequestParam versioning
		@GetMapping(value="person",params="verson=1")  // if param with name =verson and value =1 occurs in url then dispatcherservelet executes this func.
		public PersonV1 getV1PersonReqParam() {
			return new PersonV1("Adam Choudhary");
		}
		@GetMapping(value="person",params="verson=2") 
		public PersonV2 getV2PersonReqParam() {
			return new PersonV2(new Name("Camila","eve"));
		}

}	
