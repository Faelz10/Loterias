package br.com.loteria.apiloteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loteria.apiloteria.entities.Player;
import br.com.loteria.apiloteria.entities.Raffle;
import br.com.loteria.apiloteria.repository.PlayerRepository;
import br.com.loteria.apiloteria.services.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/game")
@Api(value="API LOTERIA")
@CrossOrigin(origins="*")
public class GameController {
  
  @Autowired
  private GameService gameService;

  @Autowired
	private PlayerRepository playerRepo;

	@ApiOperation(value="Create a raffle lucky number")
  @PostMapping(consumes = "application/json")
  public ResponseEntity<Raffle> addGame(@RequestBody  Player player) {
   
    try {
      Raffle raffle = gameService.postGame(player);
       
      return new ResponseEntity<>(raffle, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      
    }
 
  }
 
	@ApiOperation(value="Get all player lucky numbers")
  @GetMapping
  public ResponseEntity<List<Player>> listPlayer() {
    return ResponseEntity.ok().body(playerRepo.findAll());
 
  }
 
	@ApiOperation(value="Get a Player luck numbers by email")
  @GetMapping("/{email}")
  public ResponseEntity<Player> playerById(@PathVariable String email) {
    return ResponseEntity.ok().body(playerRepo.findByEmail(email).get());
  }   
}
