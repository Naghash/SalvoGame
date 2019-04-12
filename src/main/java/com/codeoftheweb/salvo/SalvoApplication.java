package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import static java.time.LocalDateTime.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class SalvoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class);

    }


    @Bean
    public CommandLineRunner initData(PlayerRepository repository, GameRepository repositoryGame, GamePlayerRepository repositoryGamePlayer) {
        return (args) -> {
            // save a couple of customers
            Player player1 = new Player("Rom");
            repository.save(player1);
            Player player2 = new Player("Hey");
            repository.save(player2);
            Player player3 = new Player("Cuy");
            repository.save(player3);

            Game game1 = new Game(now());
            repositoryGame.save(game1);

            LocalDateTime nextTime = LocalDateTime.now().plusHours(1);

            Game game2 = new Game(nextTime);
            repositoryGame.save(game2);

            LocalDateTime nextTime1 = LocalDateTime.now().plusHours(2);

            Game game3 = new Game(nextTime1);
            repositoryGame.save(game3);

            LocalDateTime joined = LocalDateTime.now();
            GamePlayer gamePlayer1 = new GamePlayer(joined, game3, player1);
            repositoryGamePlayer.save(gamePlayer1);



        };
    }





}