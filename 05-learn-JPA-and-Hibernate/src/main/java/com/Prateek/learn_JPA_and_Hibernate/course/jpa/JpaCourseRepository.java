//package com.Prateek.learn_JPA_and_Hibernate.course.jpa;
//
//import org.springframework.stereotype.Repository;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//
//@Repository
//@Transactional
//public class JpaCourseRepository {
//	
//	@PersistenceContext 	// PersistenceContext is more specific annotation otherwise @Autowired will also work same.
//	EntityManager entityManager; 	
//	// jese JdbcTemplate tha to talk with your CourseClass and CommandLineRunner in similiar way here it is EntityManager.
//	
//	public void insert(JpaCourse course) {
//		// DYK How insertion happen : first Hibernate check whether or not there is already a record with that same primary key if not it runs a insert query.(SIMILARLY DELETE ALSO)
//		entityManager.merge(course);
//	}
//	
//	public JpaCourse findById(int id) {
//		return entityManager.find(JpaCourse.class, id); // after finding map it with JpaCourse
//	}
//	
//	public void deleteByID(int id) {
//		JpaCourse jpc = entityManager.find(JpaCourse.class, id); // first find then delete
//		entityManager.remove(jpc);
//	}
//	
//}
//
///**
// Role of @Transactional in your JpaCourseRepository
//
//@Transactional defines a transaction boundary around the methods of this class.
//In simple terms: it tells Spring when to start, commit, or roll back a database transaction.
//
//Why it is REQUIRED for JPA operations
//1. Write operations NEED a transaction
//	
//	entityManager.merge()
//	entityManager.remove()
//	
//	Without an active transaction:
//	
//	Changes will not be flushed to the database
//	
//	You may get:
//		
//		TransactionRequiredException
//		or silent failure (no insert/delete)
//	
//	So this works only because @Transactional is present.
//
//2. Persistence Context is transaction-scoped
//
//	JPA uses a persistence context (first-level cache):
//	Entities are managed only inside a transaction
//	Dirty checking (auto update) happens at transaction commit
//	If no transaction → no lifecycle management
//
//3. Automatic commit / rollback
//
//	If method completes normally → COMMIT
//	If a runtime exception occurs → ROLLBACK
//	
//	Example:
//	
//	@Transactional
//	public void insert(JpaCourse course) {
//	    entityManager.merge(course);
//	    // if exception here → DB rollback
//	}
//	
//	
//	You did NOT write commit/rollback code — Spring handles it.
//	
//	What about findById()? Does it need a transaction?
//
//	Strictly:
//	
//	Read-only find can work without transaction
//	
//	But:
//	
//		> Lazy loading
//		
//		> Entity consistency
//		
//		> Session management
//	
//	All behave more safely inside a transaction
//	
//	In real projects:
//	
//	@Transactional(readOnly = true)
//	public JpaCourse findById(int id) { ... }
//	
//	This:
//		> Disables dirty checking
//		> Improves performance
//		> Avoids accidental updates
//	
//	
// */
