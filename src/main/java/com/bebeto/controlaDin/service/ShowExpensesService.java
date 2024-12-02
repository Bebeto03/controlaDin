package com.bebeto.controlaDin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.DespesaRepository;

@Service
public class ShowExpensesService {
    
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> despesasUsuarioLogado(){
        Usuario usuario = usuarioLogadoService.getUsuarioLogado();
        return despesaRepository.findByUsuario(usuario);
    }
    
}
