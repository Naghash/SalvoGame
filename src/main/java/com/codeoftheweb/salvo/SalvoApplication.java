package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static java.time.LocalDateTime.*;

@SpringBootApplication
public class SalvoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class);

    }


    @Bean
    public CommandLineRunner initData(PlayerRepository repositoryPlayer, GameRepository repositoryGame, GamePlayerRepository repositoryGamePlayer, ShipRepository repositoryShip) {
        return (args) -> {
            // save a couple of customers
            Player player1 = new Player("Rom");
            Player player2 = new Player("Hey");
            Player player3 = new Player("Cuy");


            Game game1 = new Game(now());
            LocalDateTime nextTime = LocalDateTime.now().plusHours(1);
            Game game2 = new Game(nextTime);
            LocalDateTime nextTime1 = LocalDateTime.now().plusHours(2);
            Game game3 = new Game(nextTime1);


            Ship ship1 = new Ship(Arrays.asList("H2","B5"), "destroyer");
            Ship ship2 = new Ship(Arrays.asList("H1","A2"), "huhu");
            Ship ship3 = new Ship(Arrays.asList("A5","B1"), "badShip");
            Ship ship4 = new Ship(Arrays.asList("C3","G3"), "goodShip");

            GamePlayer gamePlayer1 = new GamePlayer(now(), game3, player1);
            GamePlayer gamePlayer2 = new GamePlayer(now(), game2, player2);
            GamePlayer gamePlayer3 = new GamePlayer(now(), game1, player3);

            gamePlayer1.addShip(ship1);
            gamePlayer1.addShip(ship2);
            gamePlayer1.addShip(ship3);


            repositoryPlayer.save(player1);
            repositoryPlayer.save(player2);
            repositoryPlayer.save(player3);

            repositoryGame.save(game1);
            repositoryGame.save(game2);
            repositoryGame.save(game3);

            repositoryGamePlayer.save(gamePlayer1);
            repositoryGamePlayer.save(gamePlayer2);
            repositoryGamePlayer.save(gamePlayer3);

            repositoryShip.save(ship1);
            repositoryShip.save(ship2);
            repositoryShip.save(ship3);
            repositoryShip.save(ship4);





        };
    }





}