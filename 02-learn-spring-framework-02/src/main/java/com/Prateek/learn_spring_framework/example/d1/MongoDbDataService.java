package com.Prateek.learn_spring_framework.example.d1;

//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("MongoDb")
@Repository("MongoDb")  
@Primary
public class MongoDbDataService implements dataService{

	@Override
	public int[] retrieveData() {
		return new int[] {11,22,33,44,55};
	}

}
