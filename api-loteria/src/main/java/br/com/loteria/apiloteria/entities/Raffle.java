package br.com.loteria.apiloteria.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "raffle")
@NoArgsConstructor
public class Raffle implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    private String lucky_numbers;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
	@JsonBackReference
    @JoinColumn(name="player_id")
	private Player player;
    
    
    
  
}
