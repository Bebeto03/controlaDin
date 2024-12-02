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

    public List<Despesa> despesasUsuarioLogado(String sort){
        Usuario usuario = usuarioLogadoService.getUsuarioLogado();
        switch (sort){
            case "amount_desc":
                return despesaRepository.findByUsuarioOrderByAmountDesc(usuario);
            case "amount_asc":
                return despesaRepository.findByUsuarioOrderByAmountAsc(usuario);
            case "date_desc":
                return despesaRepository.findByUsuarioOrderByDeadlineDesc(usuario);
            case "date_asc":
                return despesaRepository.findByUsuarioOrderByDeadlineAsc(usuario);
            default:
                return despesaRepository.findByUsuario(usuario);
        }
    }
    
}
