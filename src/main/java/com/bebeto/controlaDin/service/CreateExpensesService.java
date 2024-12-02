package com.bebeto.controlaDin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bebeto.controlaDin.dto.DespesaDto;
import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.DespesaRepository;

@Service
public class CreateExpensesService {
    
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private DespesaRepository despesaRepository;

    public boolean criarDespesa(DespesaDto despesaDto, BindingResult result){
        if(result.hasErrors()){
            return false;
        }
        Usuario usuario = usuarioLogadoService.getUsuarioLogado();
        Despesa despesa = new Despesa();
        despesa.setName(despesaDto.getName());
        despesa.setDescription(despesaDto.getDescription());
        despesa.setAmount(despesaDto.getAmount());
        despesa.setDeadline(despesaDto.getDeadline());
        despesa.setStatus(despesaDto.getStatus());
        despesa.setUsuario(usuario);
        despesaRepository.save(despesa);
        return true;
    }
}
