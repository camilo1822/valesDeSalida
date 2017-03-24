package com.familia.vales.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.familia.vales.jpa.entities.OperacionVale;

@Repository
public interface OperacionValeRepository extends JpaRepository<OperacionVale, Integer> {
	/*delete vale*/
	void delete(OperacionVale elim);
}
