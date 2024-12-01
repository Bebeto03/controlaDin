package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bebeto.controlaDin.dto.ReceitaDto;
import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.ReceitaRepository;
import com.bebeto.controlaDin.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Controller
public class CreateIncomesController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/controlaDin/incomes/new")
    public String showNewIncomePage(Model model){
        model.addAttribute("receitaDto", new ReceitaDto());
        return "newIncome";
    }

    @PostMapping("controlaDin/incomes/new")
    public String createNewIncome(Model model, @Valid @ModelAttribute ReceitaDto receitaDto, BindingResult result){
        
        if(result.hasErrors()){
            return "newIncome";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmail(email);

        Receita newReceita = new Receita();
        newReceita.setName(receitaDto.getName());
        newReceita.setDescription(receitaDto.getDescription());
        newReceita.setAmount(receitaDto.getAmount());
        newReceita.setStatus(receitaDto.getStatus());
        newReceita.setReceipt(receitaDto.getReceipt());
        newReceita.setUsuario(usuario);

        receitaRepository.save(newReceita);
        return "redirect:/controlaDin/incomes";
    }

}
