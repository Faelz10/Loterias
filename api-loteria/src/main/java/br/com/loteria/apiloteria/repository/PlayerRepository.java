package br.com.loteria.apiloteria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loteria.apiloteria.entities.Player;

@Repository
public interface PlayerRepository  extends JpaRepository<Player, Long>{

    Optional<Player> findByEmail(String email);

    
}
