package com.Prateek.learn_spring_framework.example.d1;

//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("MySql")
@Repository("MySql")
public class MYSQLDataService implements dataService{

	@Override
	public int[] retrieveData() {
		return new int[] {1,2,3,4,5};
	}

}
