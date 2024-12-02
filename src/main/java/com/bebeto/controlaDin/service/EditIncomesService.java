package com.bebeto.controlaDin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bebeto.controlaDin.dto.ReceitaDto;
import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.repository.ReceitaRepository;

@Controller
public class EditIncomesService {
    
    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita carregarReceita(long id){
        Receita receita = receitaRepository.findById(id);
        return receita;
    }

    public ReceitaDto mostrarReceita(Receita receita){
        ReceitaDto receitaDto = new ReceitaDto();
        receitaDto.setName(receita.getName());
        receitaDto.setDescription(receita.getDescription());
        receitaDto.setAmount(receita.getAmount());
        receitaDto.setReceipt(receita.getReceipt());
        receitaDto.setStatus(receita.getStatus());
        return receitaDto;
    }

    public void atualizarReceita(Receita receita, ReceitaDto receitaDto){
        receita.setName(receitaDto.getName());
        receita.setDescription(receitaDto.getDescription());
        receita.setAmount(receitaDto.getAmount());
        receita.setReceipt(receitaDto.getReceipt());
        receita.setStatus(receitaDto.getStatus());
        receitaRepository.save(receita);
    }
}
