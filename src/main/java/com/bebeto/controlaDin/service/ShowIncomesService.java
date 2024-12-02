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

    public List<Receita> receitasUsuarioLogado(String sort){
        Usuario usuario = usuarioLogadoService.getUsuarioLogado();
        switch(sort){
            case "amount_desc":
                return receitaRepository.findByUsuarioOrderByAmountDesc(usuario);
            case "amount_asc":
                return receitaRepository.findByUsuarioOrderByAmountAsc(usuario);
            case "date_desc":
                return receitaRepository.findByUsuarioOrderByReceiptDesc(usuario);
            case "date_asc":
                return receitaRepository.findByUsuarioOrderByReceiptAsc(usuario);
            default:
                return receitaRepository.findByUsuario(usuario);
        }
    }

}
