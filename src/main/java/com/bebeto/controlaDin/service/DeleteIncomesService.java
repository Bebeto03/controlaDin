package com.bebeto.controlaDin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.repository.ReceitaRepository;

@Service
public class DeleteIncomesService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public void apagarReceita(long id){
        Receita receita = receitaRepository.findById(id);
        if(receita!=null){
            receitaRepository.delete(receita);
        }
    }
}
