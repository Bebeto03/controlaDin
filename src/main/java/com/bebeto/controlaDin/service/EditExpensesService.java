package com.bebeto.controlaDin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bebeto.controlaDin.dto.DespesaDto;
import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.repository.DespesaRepository;

@Service
public class EditExpensesService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa carregarDespesa(long id){
        Despesa despesa = despesaRepository.findById(id);
        return despesa;
    }

    public DespesaDto mostrarDespesa(Despesa despesa){
        DespesaDto despesaDto = new DespesaDto();
        despesaDto.setName(despesa.getName());
        despesaDto.setDescription(despesa.getDescription());
        despesaDto.setAmount(despesa.getAmount());
        despesaDto.setDeadline(despesa.getDeadline());
        despesaDto.setStatus(despesa.getStatus());
        return despesaDto;
    }

    public void atualizarDespesa(Despesa despesa, DespesaDto despesaDto){
        despesa.setName(despesaDto.getName());
        despesa.setDescription(despesaDto.getDescription());
        despesa.setAmount(despesaDto.getAmount());
        despesa.setDeadline(despesaDto.getDeadline());
        despesa.setStatus(despesaDto.getStatus());
        despesaRepository.save(despesa);
    }
}
