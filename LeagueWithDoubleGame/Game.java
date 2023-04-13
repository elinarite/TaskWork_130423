package TaskWorkHomework2.LeagueWithDoubleGame;

import java.util.*;

public class Game {

    Set<Player> playersList = new HashSet<>();
    EnumMap<League, List<Player>> leagueList = new EnumMap<>(League.class);
    private EnumMap<League, List<Player>> playGame() {

        ServiceLeague serviceLeague = new ServiceLeague();

        //создаем список игроков
        serviceLeague.createLeague(playersList);
        //создаем список лиг, в каждой по 5 игроков
        serviceLeague.createLeagueList(leagueList, playersList);

        ServiceGame serviceGame = new ServiceGame();
        //игра, где каждый игрок играет с другим игроком в своей лиге
        serviceGame.game(leagueList);
       //  дополнительная игра между игроками, которые имеют одинаковое количество очков
        serviceGame.playAdditionalGames(leagueList);
        //сортируется каждый список игроков по убыванию очков
        serviceGame.sortMap(leagueList);
        return leagueList;
    }

    public void print() {
        playGame();
        for (League league : leagueList.keySet()) {
            List<Player> players = leagueList.get(league);
            System.out.printf("%s:%n", league);
            for (Player player : players) {
                System.out.printf("  %s, score: %.1f%n", player.getName(), player.getScore());
            }
            System.out.println("-------------------------");
        }
    }
}