package com.example.demo.Repository;

import com.example.demo.Model.M_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Usuario extends JpaRepository<M_Usuario, Long> {
    @Query(value = "SELECT * FROM usuario WHERE usuario = :usuario AND senha = :senha", nativeQuery = true)
    M_Usuario BuscarPorNomeSenha(@Param("usuario")String usuario, @Param("senha") String senha);
}
