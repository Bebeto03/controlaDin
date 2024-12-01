package com.bebeto.controlaDin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.model.Usuario;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    public List<Receita> findByUsuario(Usuario usuario);
    
}
