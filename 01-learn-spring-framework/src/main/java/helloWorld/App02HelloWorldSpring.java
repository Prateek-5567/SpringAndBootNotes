package helloWorld;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	public static void main(String[] args) {
				
// this is called : try with resources ;
//try whatever there is inside () if fail :=> catch error.	
		try (//1. Launch Spring Context using : (using HelloWorld class)
		var context = new AnnotationConfigApplicationContext(HelloWorld.class)) {
			//2. use the context to configure things that you want Spring to manage for you.
			var usage = context.getBean("name");
			System.out.println(usage);
			// sysout + control + space 
			
			var temp1 = context.getBean("age");
			System.out.println(temp1);
			
			System.out.println(context.getBean("person"));  // return type : Record ~ similiar to how an object is returned.
			System.out.println(context.getBean("coustomName"));
			
			
			// create coustom Person using the existing beans and records 
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person2ParametersPass"));
			
			System.out.println(context.getBean("address2"));
			System.out.println(context.getBean("person3"));
			
//		there is another way to retireve Bean : using class name :
//		System.out.println(context.getBean(Address.class));  // currently this will raise error as there are more than one instances of Address class which one to return?
			// comment out address2 : above line will run.	
			
			// List all spring beans defined in context
			String[] allBeans= context.getBeanDefinitionNames();
			for(var s:allBeans) {
				System.out.println(s);
			}
			
			System.out.println(context.getBean(Address.class));//  no ambiguity now as : one of the Address Bean is Primary.
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// if you dont use try-with-resources then there will be a warning at context 




