package com.bebeto.controlaDin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDto {
    
    @NotBlank(message = "Preencha o campo acima.")
    private String name;

    @NotBlank(message = "Preencha o campo acima.")
    @Email(message = "Informe um e-mail válido.")
    private String email;

    @NotBlank(message = "Preencha o campo  acima.")
    @Size(min = 8, message = "A senha deve possuir no mínimo 8 caracteres.")
    private String password;

    private String confirmPassword;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getConfirmPassword(){
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword){
        this.confirmPassword = confirmPassword;
    }
}
