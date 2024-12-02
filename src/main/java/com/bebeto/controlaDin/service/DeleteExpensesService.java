package com.bebeto.controlaDin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.repository.DespesaRepository;

@Service
public class DeleteExpensesService {

    @Autowired
    private DespesaRepository despesaRepository;

    public void apagarDespesa(long id){
        Despesa despesa = despesaRepository.findById(id);
        if(despesa!=null){
            despesaRepository.delete(despesa);
        }
    }
}
