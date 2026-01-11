package com.Prateek.learn_spring_framework.example.a2;

//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("MongoDb")
@Primary
public class MongoDbDataService implements dataService{

	@Override
	public int[] retrieveData() {
		return new int[] {11,22,33,44,55};
	}

}
