package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bebeto.controlaDin.dto.DespesaDto;
import com.bebeto.controlaDin.repository.DespesaRepository;
import com.bebeto.controlaDin.repository.UsuarioRepository;

@Controller
public class ExpensesController {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/controlaDin/expenses")
    public String showExpensesPage(){
        return "expenses";
    }

    @GetMapping("/controlaDin/expenses/new")
    public String showNewExpensePage(Model model){
        model.addAttribute("despesaDto", new DespesaDto());
        return "newExpense";
    }
}
