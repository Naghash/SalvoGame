package com.codeoftheweb.salvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

@RestController
public class SalvoController {

    @Autowired
    private GameRepository repositoryGame;
    @RequestMapping("/api/games")
    public List<Object> getGame() {
        return repositoryGame
                .findAll()
                .stream()
                .map(game ->
                        new LinkedHashMap<String, Object>() {{
                            put("id", game.getId());
                            put("created", game.getCreationDate());
                            put("gameplayers", game.getGamePlayers().stream()
                                    .map(gp -> gp.toDTO()).collect(toList()));
                        }}).collect(toList());

    }
    @Autowired
    private GamePlayerRepository repositoryGamePlayer;
    @RequestMapping("/api/game_view/{gamePlayerId}")
    private List<Map<String, Object>> makeDTO( @PathVariable Long gamePlayerId) {
        return repositoryGamePlayer.findAll()
                .stream()
                .filter(gamePlayer -> gamePlayer.getId() == gamePlayerId)
                .map(gamePlayer -> gamePlayer.getGame())
                .map(game ->
                new LinkedHashMap<String, Object>() {{
                    put("id", game.getId());
                    put("created", game.getCreationDate());
                    put("gameplayers", game.getGamePlayers().stream()
                            .map(gp -> gp.toDTO())
                            .collect(toList()));
                }}).collect(toList());
    }
    @Autowired
    private PlayerRepository repositoryPlayer;

    @RequestMapping("/api/players")
    public List<Player> getPlayer() {

        return repositoryPlayer.findAll();

    }
}
