package com.example.carg.repository;

import com.example.carg.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
//DATABASE E DATA UPDATE DELETE ESOB ER JONNO REPOSITORY USE HOY
public interface UserRepository extends JpaRepository<UserDtls,Integer> {
     public boolean existsByEmail(String email);
     public UserDtls findByEmail(String email);



}
