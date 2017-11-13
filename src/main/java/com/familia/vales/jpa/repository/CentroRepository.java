package com.familia.vales.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.familia.vales.jpa.entities.Centro;
@Repository
public interface CentroRepository extends JpaRepository<Centro, Integer> {
	void delete(Centro elim);
}
