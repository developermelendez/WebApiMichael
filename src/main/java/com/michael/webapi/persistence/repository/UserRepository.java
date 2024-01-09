
package com.michael.webapi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.michael.webapi.persistence.entity.User;
import java.util.List;



public interface UserRepository extends JpaRepository<User, Long> {    

    public List<User> findAll();
}
