package com.masatrio.springcrud.masatriospringbootcrud.repository;


import com.masatrio.springcrud.masatriospringbootcrud.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{

}