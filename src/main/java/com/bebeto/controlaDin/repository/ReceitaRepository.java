package com.bebeto.controlaDin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebeto.controlaDin.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    
}
