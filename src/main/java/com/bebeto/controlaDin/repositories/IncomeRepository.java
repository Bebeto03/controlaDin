package com.bebeto.controlaDin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebeto.controlaDin.entities.Income;

public interface IncomeRepository extends JpaRepository<Income, Long>{}
