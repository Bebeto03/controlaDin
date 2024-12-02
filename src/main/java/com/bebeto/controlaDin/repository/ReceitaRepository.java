package com.bebeto.controlaDin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.model.Usuario;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    public List<Receita> findByUsuario(Usuario usuario);
    public List<Receita> findByUsuarioOrderByAmountDesc(Usuario usuario);
    public List<Receita> findByUsuarioOrderByAmountAsc(Usuario usuario);
    public List<Receita> findByUsuarioOrderByReceiptDesc(Usuario usuario);
    public List<Receita> findByUsuarioOrderByReceiptAsc(Usuario usuario);
    public Receita findById(long id);
    
}
