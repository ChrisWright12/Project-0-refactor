package com.rev.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.rev.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
   
    User findById(int id);
  
	@Query("select u from User u where u.username = :Username")
	User findLogin(@Param("Username")String username);

}
