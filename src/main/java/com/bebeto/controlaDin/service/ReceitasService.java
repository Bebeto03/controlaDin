package com.bebeto.controlaDin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import com.bebeto.controlaDin.dto.ReceitaDto;
import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.ReceitaRepository;

public class ReceitasService {
    
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private ReceitaRepository receitaRepository;

    public List<Receita> listarReceitas(String sort){
        Usuario usuario = usuarioLogadoService.getUsuarioLogado();
        switch(sort){
            case "amount_asc":
                return receitaRepository.findByUsuarioOrderByAmountAsc(usuario);
            case "amount_desc":
                return receitaRepository.findByUsuarioOrderByAmountDesc(usuario);
            case "date_asc":
                return receitaRepository.findByUsuarioOrderByReceiptAsc(usuario);
            case "date_desc":
                return receitaRepository.findByUsuarioOrderByReceiptDesc(usuario);
            default:
                return receitaRepository.findByUsuario(usuario);
        }
    }

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

    public Receita carregarReceita(long id){
        Receita receita = receitaRepository.findById(id);
        return receita;
    }

    public ReceitaDto visualizarReceita(Receita receita){
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

    public void excluirReceita(long id){
        Receita receita = receitaRepository.findById(id);
        if(receita!=null){
            receitaRepository.delete(receita);
        }
    }

}
