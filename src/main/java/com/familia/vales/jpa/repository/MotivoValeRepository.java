package com.familia.vales.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.familia.vales.jpa.entities.MotivoVale;

@Repository
public interface MotivoValeRepository extends JpaRepository<MotivoVale, Integer> {
	
}
