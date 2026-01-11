package com.Prateek.learn_spring_framework.example.a2;

//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("MySql")
public class MYSQLDataService implements dataService{

	@Override
	public int[] retrieveData() {
		return new int[] {1,2,3,4,5};
	}

}
