package com.bebeto.controlaDin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_income")
public class Income {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double amount;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    private User user;

    public Income(){}

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public double getAmount(){
        return amount;
    }

    public void setValue(double amount){
        this.amount = amount;
    }

}
