package br.com.loteria.apiloteria.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "player")
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    // @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JsonManagedReference
	private List<Raffle> raffle = new ArrayList<>();
  
}
