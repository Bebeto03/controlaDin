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

import com.bebeto.controlaDin.dto.DespesaDto;
import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.DespesaRepository;
import com.bebeto.controlaDin.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Controller
public class CreateExpensesController {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/controlaDin/expenses/new")
    public String showNewExpensePage(Model model){
        model.addAttribute("despesaDto", new DespesaDto());
        return "newExpense";
    }

    @PostMapping("/controlaDin/expenses/new")
    public String createNewExpense(Model model, @Valid @ModelAttribute DespesaDto despesaDto, BindingResult result){

        if(result.hasErrors()){
            return "newExpense";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmail(email);

        Despesa newDespesa = new Despesa();
        newDespesa.setName(despesaDto.getName());
        newDespesa.setDescription(despesaDto.getDescription());
        newDespesa.setAmount(despesaDto.getAmount());
        newDespesa.setStatus(despesaDto.getStatus());
        newDespesa.setDeadline(despesaDto.getDeadline());
        newDespesa.setUsuario(usuario);

        despesaRepository.save(newDespesa);
        return "redirect:/controlaDin/expenses";
    }

}
