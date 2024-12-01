package com.bebeto.controlaDin.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DespesaDto {
    
    @NotBlank(message = "Preencha o campo acima.")
    private String name;

    private String description;

    @Positive(message = "Informe um valor positivo.")
    private double amount;

    @NotBlank(message = "Selecione um status.")
    private String status;

    @NotNull(message = "Selecione uma data.")
    private LocalDate dayPayment;

    public String getName(){
        return name;
    }

    public void setNome(String name){
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

    public LocalDate getDayPayment(){
        return dayPayment;
    }

    public void setDayPayment(LocalDate dayPayment){
        this.dayPayment = dayPayment;
    }

}
