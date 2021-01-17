package br.com.loteria.apiloteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loteria.apiloteria.entities.Raffle;

@Repository
public interface RaffleRepository  extends JpaRepository<Raffle, Long>{}
