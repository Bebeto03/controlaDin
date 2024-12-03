package com.bebeto.controlaDin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebeto.controlaDin.dto.DespesaDto;
import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.service.DespesasService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/controlaDin/expenses")
public class DespesasController {
    
    @Autowired
    private DespesasService despesasService;

    @GetMapping({"", "/"})
    public String carregarPaginaDespesas(Model model, @RequestParam(name = "sort", defaultValue = "default") String sort){
        List<Despesa> despesas = despesasService.listarDespesas(sort);
        model.addAttribute("sort", sort);
        model.addAttribute("despesas", despesas);
        return "expenses";
    }

    @GetMapping("/new")
    public String carregarPaginaNovaDespesa(Model model){
        model.addAttribute("despesaDto", new DespesaDto());
        return "newExpense";
    }

    @PostMapping("/new")
    public String criarNovaDespesa(Model model, @Valid @ModelAttribute DespesaDto despesaDto, BindingResult result){
        if(!despesasService.criarDespesa(despesaDto, result)){
            return "newExpense";
        }
        return "redirect:/controlaDin/expenses";
    }

    @GetMapping("/edit")
    public String carregarPaginaEditarDespesa(Model model, @RequestParam long id){
        Despesa despesa = despesasService.carregarDespesa(id);
        if(despesa==null){
            return "redirect:/controlaDin/expenses";
        }
        DespesaDto despesaDto = despesasService.visualizarDespesa(despesa);
        model.addAttribute("despesa", despesa);
        model.addAttribute("despesaDto", despesaDto);
        return "editExpense";
    }

    @PostMapping("/edit")
    public String editarDespesa(Model model, @RequestParam long id, DespesaDto despesaDto, BindingResult result){
        Despesa despesa = despesasService.carregarDespesa(id);
        if(despesa==null){
            return "redirect:/controlaDin/expenses";
        }
        model.addAttribute("despesa", despesa);
        if(result.hasErrors()){
            return "editExpense";
        }
        despesasService.atualizarDespesa(despesa, despesaDto);
        return "redirect:/controlaDin/expenses";
    }

    @GetMapping("/delete")
    public String excluirDespesa(@RequestParam long id){
        despesasService.excluirDespesa(id);
        return "redirect:/controlaDin/expenses";
    }

}
