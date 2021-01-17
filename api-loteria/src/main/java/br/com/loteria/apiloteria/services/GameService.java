package br.com.loteria.apiloteria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loteria.apiloteria.entities.Player;
import br.com.loteria.apiloteria.entities.Raffle;
import br.com.loteria.apiloteria.repository.PlayerRepository;
import br.com.loteria.apiloteria.repository.RaffleRepository;

@Service
public class GameService {

    @Autowired
	private PlayerRepository playerRepo;

	@Autowired
    private RaffleRepository raffleRepo;
    

    //Post 
    public Raffle postGame(Player player) {
        Optional<Player> playerExistent = playerRepo.findByEmail(player.getEmail());
      

		if (playerExistent.isPresent()) {
               
			Raffle raffle = new Raffle();
			raffle.setLucky_numbers(drawEdited());
            raffle.setPlayer(playerExistent.get());

            raffleRepo.save(raffle);

            playerExistent.get().getRaffle().add(raffle);
            
			return raffle;
		} else {
			playerRepo.save(player);
            return postGame(player);
		}
        
	}

    static List<String> draw() {
        List<String> luck_numbers_game = new ArrayList<>();
        int numero;
        int[] num = new int[6];
        Random r = new Random();

        for (int i = 0; i < num.length; i++) {
            numero = r.nextInt(60) + 1;
            for (int j = 0; j < num.length; j++) {
                if (numero == num[j] && j != i) {
                    numero = r.nextInt(60) + 1;
                } else {
                    num[i] = numero;

                }
            }
        }

        for (int i = 0; i < num.length; i++) {
            luck_numbers_game.add(Integer.toString(num[i]));
        }

        return luck_numbers_game;

    }

    static String drawEdited(){
        String drawreturn = draw().toString();
        drawreturn = drawreturn.replace(",","");
        drawreturn = drawreturn.replace("[","");
        drawreturn = drawreturn.replace("]","");


        return drawreturn;
    }

    
}
