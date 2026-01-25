package com.Prateek.learn_JPA_and_Hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepositoryInsert {
	
	@Autowired
	private JdbcTemplate courseJdbcTemplate; // you need an object of JdbcTemplate to talk to db
	
	private static String INSERT_QUERY = """
			INSERT INTO COURSE (ID,NAME,AUTHOR)
			 VALUES(?,?,?); 
			"""; 				 // '?' is wrong : auto it comes as String.
	
	private static String DELETE_QUERY = """
			DELETE FROM COURSE WHERE ID=?
			""";
	
	private static String SELECT_QUERY = """
			SELECT * FROM COURSE WHERE ID = ?
			""";
	
	public void insert(Course course) {
		// this is just a simple method with hardcoded values , we can also take id as parameter of function.
		courseJdbcTemplate.update(INSERT_QUERY,
				course.getId(),course.getName(),course.getAuthor());
	}
	
	public void delete(Course course) {
		courseJdbcTemplate.update(DELETE_QUERY,course.getId());
	}
	
	public Course findCourseById(int id) {
		// I have used queryForObject method because it has a special parameter : RowMapper
		// what is row mapper ; the resultSet that we get from database will be an object {..} like structure
		// we would have to map the resultSet to some Object ;
		// in current scenario all the keys in ResultObject directly matches to a Course class fields to you can directly pass an object of 
		// Course class to RowMapper so that the ResultObject gets mapped to our CourseObject
		// this is called Mapping ResultSet to Bean and is Done By BeanPropertyRowMapper<> 
		return courseJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class), id);
	
		// one more imp thing : Your class to which you are mapping theb result must contain Setters because that is neccesary to setValues.
	}
}
