package helloWorld;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Bean;

record Person(int id,String name,Address add) {}

record Address(String Street,String City,String State,int pin) {}

@Configuration
public class HelloWorld {
	// helloWorld ki configuration file create hogi to access it : even that is managed as a seperate Bean.
	
	@Bean
	public String name() {
		return "Prateek";
	}
	
	@Bean
	public int age() {
		return 21; 
	}
	
	@Bean 
	public Person person() {
		return new Person(1,"Prateek",new Address("BeachSide","Wellington","NZ",1011)); // this Address means to call record not to use Bean.
	}
	
	// if you pass any coustom name ="--" something inside () of Bean definition 
	@Bean(name = "coustomName")
	public Address address() {
		return new Address("Gold Coast","Brisbane","QueensLand",1500);
	}
	
	// Here i am creating a new Bean using other Beans as method call in it..
	@Bean
	public Person person2MethodCall() {
		return new Person(age(),name(),address()); 
		// here you are calling Bean not record : also you have to use the original name of bean not coustom name.
	} //  here we call the beans with actual method name not the coustom Name (as it is Method call type.)
	 
	
	// in parameterised method the method auto findes the Beans with matching names.
	@Bean
	public Person person2ParametersPass(String name,int age,Address coustomName) {
		return new Person(age,name,coustomName);
	}
	// here you pass parameters : But the parameters must be your Bean names
	// in case of coustom name use coustom name only not the method name here.
	
	@Bean(name  = "address2")
	@Primary
	public Address address2(){
		return new Address("RailwayLine","Auckland","NZ",1012);
	}
	
	@Bean 
	public Person person3() {
		return new Person(age(),name(),address2());
	}
	
} 
