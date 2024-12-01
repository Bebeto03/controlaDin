package com.bebeto.controlaDin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.model.Usuario;
import com.bebeto.controlaDin.repository.DespesaRepository;
import com.bebeto.controlaDin.repository.UsuarioRepository;

@Controller
@RequestMapping("/controlaDin/expenses")
public class ShowExpensesController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    @GetMapping({"", "/"})
    public String showExpensesPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmail(email);
        List<Despesa> despesas = despesaRepository.findByUsuario(usuario);
        model.addAttribute("despesas", despesas);
        return "expenses";
    }

}
