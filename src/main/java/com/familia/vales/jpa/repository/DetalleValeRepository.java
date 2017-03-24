package com.familia.vales.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.familia.vales.jpa.entities.DetalleVale;

@Repository
public interface DetalleValeRepository extends JpaRepository<DetalleVale, Integer> {
	void delete(DetalleVale elim);
}
