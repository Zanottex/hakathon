package com.example.demo.Repository;

import com.example.demo.Model.M_Arduino;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface R_Arduino extends JpaRepository<M_Arduino, Long>{

}
