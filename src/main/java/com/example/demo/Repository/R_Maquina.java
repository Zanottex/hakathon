package com.example.demo.Repository;

import com.example.demo.Model.M_Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface R_Maquina extends JpaRepository<M_Maquina, Long> {
}
