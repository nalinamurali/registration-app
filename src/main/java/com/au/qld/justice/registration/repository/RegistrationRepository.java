package com.au.qld.justice.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.au.qld.justice.registration.model.User;

public interface RegistrationRepository extends JpaRepository<User, Long>{

	public User findUserById(Long userId);
	
	public List<User> findByGender(String gender);
	
	@Query(value = "select * from user u where u.name like %:keyword% or lower(gender) like lower(:keyword) or email like %:keyword%", nativeQuery = true)
	public List<User> findByKeyword(@Param("keyword") String keyword);
	
	
}
