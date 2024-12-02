package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.repository.DespesaRepository;

@Controller
public class DeleteExpensesCintroller {

    @Autowired
    private DespesaRepository despesaRepository;

    @GetMapping("/controlaDin/expenses/delete")
    public String deleteExpense(@RequestParam long id){
        Despesa despesa = despesaRepository.findById(id);
        if(despesa!=null){
            despesaRepository.delete(despesa);
        }
        return "redirect:/controlaDin/expenses";
    }
}
