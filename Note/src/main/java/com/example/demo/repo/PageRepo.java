package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.pojo.Page;

@Repository
public interface PageRepo extends JpaRepository<Page, Integer>{

}
