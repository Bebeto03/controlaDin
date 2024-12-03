package com.bebeto.controlaDin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bebeto.controlaDin.dto.DespesaDto;
import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.DespesaRepository;

@Service
public class DespesasService {
    
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> listarDespesas(String sort){
        Usuario usuario = usuarioLogadoService.getUsuarioLogado();
        switch(sort){
            case "amount_asc":
                return despesaRepository.findByUsuarioOrderByAmountAsc(usuario);
            case "amount_desc":
                return despesaRepository.findByUsuarioOrderByAmountDesc(usuario);
            case "deadline_asc":
                return despesaRepository.findByUsuarioOrderByDeadlineAsc(usuario);
            case "deadline_desc":
                return despesaRepository.findByUsuarioOrderByDeadlineDesc(usuario);
            default:
                return despesaRepository.findByUsuario(usuario);
        }
    }

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

    public Despesa carregarDespesa(long id){
        Despesa despesa = despesaRepository.findById(id);
        return despesa;
    }

    public DespesaDto visualizarDespesa(Despesa despesa){
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

    public void excluirDespesa(long id){
        Despesa despesa = despesaRepository.findById(id);
        if(despesa!=null){
            despesaRepository.delete(despesa);
        }
    }

}
