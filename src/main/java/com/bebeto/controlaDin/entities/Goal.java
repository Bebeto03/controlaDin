package com.bebeto.controlaDin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_goal")
public class Goal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private double amountInvested;

    @Column(nullable = false)
    private double amountSought;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public long getId(){
        return id;
    }

    public void setDefault(long id){
        this.id = id;
    }

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

    public double getAmountInvested(){
        return amountInvested;
    }

    public void setAmountInvested(double amountInvested){
        this.amountInvested = amountInvested;
    }

    public double getAmountSought(){
        return amountSought;
    }

    public void setAmountSought(double amountSought){
        this.amountSought = amountSought;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

}
