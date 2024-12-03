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

import com.bebeto.controlaDin.dto.ReceitaDto;
import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.service.ReceitasService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/controlaDin/incomes")
public class ReceitasController {

    @Autowired
    private ReceitasService receitasService;

    @GetMapping({"", "/"})
    public String carregarPaginaReceitas(Model model, @RequestParam(name = "sort", defaultValue = "default") String sort){
        List<Receita> receitas = receitasService.listarReceitas(sort);
        model.addAttribute("receitas", receitas);
        model.addAttribute("sort", sort);
        return "incomes";
    }

    @GetMapping("/new")
    public String carregarPaginaNovaReceita(Model model){
        model.addAttribute("receitaDto", new ReceitaDto());
        return "newIncome";
    }

    @PostMapping("/new")
    public String criarNovaReceita(Model model, @Valid @ModelAttribute ReceitaDto receitaDto, BindingResult result){
        if(!receitasService.criarReceita(receitaDto, result)){
            return "newIncome";
        }
        return "redirect:/controlaDin/incomes";
    }

    @GetMapping("/edit")
    public String carregarPaginaEditarReceita(Model model, @RequestParam long id){
        Receita receita = receitasService.carregarReceita(id);
        if(receita==null){
            return "redirect:/controlaDin/incomes";
        }
        ReceitaDto receitaDto = receitasService.visualizarReceita(receita);
        model.addAttribute("receita", receita);
        model.addAttribute("receitaDto", receitaDto);
        return "editIncome";
    }

    @PostMapping("/edit")
    public String editarReceita(Model model, @RequestParam long id, @Valid @ModelAttribute ReceitaDto receitaDto, BindingResult result){
        Receita receita = receitasService.carregarReceita(id);
        if(receita==null){
            return "redirect:/controlaDin/incomes";
        }
        model.addAttribute("receita", receita);
        if(result.hasErrors()){
            return "editIncome";
        }
        receitasService.atualizarReceita(receita, receitaDto);
        return "redirect:/controlaDin/incomes";
    }

    @GetMapping("/delete")
    public String excluirReceita(@RequestParam long id){
        receitasService.excluirReceita(id);
        return "redirect:/controlaDin/incomes";
    }

}
