package com.familia.vales.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.familia.vales.jpa.entities.Vale;

@Repository
public interface ValeRepository extends JpaRepository<Vale, Integer> {
	/*delete vale*/
	void delete(Vale elim);
}
