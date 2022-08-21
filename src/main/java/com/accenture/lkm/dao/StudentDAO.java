package com.accenture.lkm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.lkm.entity.StudentEntity;

public interface StudentDAO  extends JpaRepository<StudentEntity, Integer>{

}
