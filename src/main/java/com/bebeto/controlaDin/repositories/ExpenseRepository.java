package com.bebeto.controlaDin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebeto.controlaDin.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{}