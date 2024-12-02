package com.bebeto.controlaDin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.model.Usuario;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    public List<Despesa> findByUsuario(Usuario usuario);
    public Despesa findById(long id);
    
}
