package com.bebeto.controlaDin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bebeto.controlaDin.dto.ReceitaDto;
import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.ReceitaRepository;

@Service
public class CreateIncomesService {
    
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private ReceitaRepository receitaRepository;

    public boolean criarReceita(ReceitaDto receitaDto, BindingResult result){
        if(result.hasErrors()){
            return false;
        }
        Usuario usuario = usuarioLogadoService.getUsuarioLogado();
        Receita novaReceita = new Receita();
        novaReceita.setName(receitaDto.getName());
        novaReceita.setDescription(receitaDto.getDescription());
        novaReceita.setAmount(receitaDto.getAmount());
        novaReceita.setReceipt(receitaDto.getReceipt());
        novaReceita.setStatus(receitaDto.getStatus());
        novaReceita.setUsuario(usuario);
        receitaRepository.save(novaReceita);
        return true;
    }
}
