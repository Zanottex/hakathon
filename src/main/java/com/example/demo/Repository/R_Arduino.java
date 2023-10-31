package com.example.demo.Repository;

import com.example.demo.Model.M_Arduino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface R_Arduino extends JpaRepository<M_Arduino, Long>{
    @Query(value = "select * from dados order by id desc limit 1", nativeQuery = true)
    M_Arduino findLastReg();
}
