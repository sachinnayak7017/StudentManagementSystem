package com.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Student.entity.Students;



@Repository
public interface StudentRepo extends JpaRepository<Students, Integer> {

}
