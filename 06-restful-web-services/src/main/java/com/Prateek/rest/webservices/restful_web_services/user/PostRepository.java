package com.Prateek.rest.webservices.restful_web_services.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
// controller talks to db via Repository

// to link database and your Controller this file is the bridge.
// for User table we had UserRepository.
// for Post table we have PostRepository.

// you can however do the work of PostJpaController in UserJpaController itself chota sa kaam h .
