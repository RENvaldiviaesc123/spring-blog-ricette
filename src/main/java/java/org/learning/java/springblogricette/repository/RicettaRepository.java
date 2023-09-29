package java.org.learning.java.springblogricette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.org.learning.java.springblogricette.model.Ricetta;

public interface RicettaRepository extends JpaRepository<Ricetta, Integer> {
}
