package com.bebeto.controlaDin.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ReceitaDto {
    
    @NotBlank(message = "Preencha o campo acima.")
    private String name;

    private String description;

    @Positive
    private double amount;

    @NotBlank(message = "Selecione um status.")
    private String status;

    @NotBlank(message = "Selecione uma data.")
    private LocalDate receipt;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public LocalDate getReceipt(){
        return receipt;
    }

    public void setReceipt(LocalDate receipt){
        this.receipt = receipt;
    }

}
