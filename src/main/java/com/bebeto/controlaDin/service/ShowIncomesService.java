package com.bebeto.controlaDin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.ReceitaRepository;

@Service
public class ShowIncomesService {

    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private ReceitaRepository receitaRepository;

    public List<Receita> receitasUsuarioLogado(){
        Usuario usuario = usuarioLogadoService.getUsuarioLogado();
        return receitaRepository.findByUsuario(usuario);
    }

}
