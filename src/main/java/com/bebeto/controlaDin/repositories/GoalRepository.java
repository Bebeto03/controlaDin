package com.bebeto.controlaDin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebeto.controlaDin.entities.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {}
