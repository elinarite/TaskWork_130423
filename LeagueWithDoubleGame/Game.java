package TaskWorkHomework2.LeagueWithDoubleGame;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Game {

    /**
     * Метод createObject создает и инициализирует EnumMap<League, List<Player>> leagueList,
     * используя CreateLeague и CreateGame, которые создают список игроков и игры.
     */
    private EnumMap<League, List<Player>> createObject() {
        //Сначала создается пустой список игроков playerList
        List<Player> playerList = new ArrayList<>();
        //Затем создается пустой EnumMap<League, List<Player>> leagueList, используя конструктор EnumMap с параметром League.class.
        EnumMap<League, List<Player>> leagueList = new EnumMap<>(League.class);

        CreateLeague createLeague = new CreateLeague();
        CreateGame createGame = new CreateGame();

        //Сначала вызывается метод createLeague у объекта createLeague,
        // который заполняет playerList пятью игроками
        createLeague.createLeague(playerList);

        //вызывает метод game у объекта createGame, который создает игры между игроками в playerList
        //Затем вызывается метод doubleGame у объекта createGame,
        // который создает дополнительные игры между игроками в playerList
        createGame.doubleGame(createGame.game(playerList));

        //Затем вызывается метод createLeagueList у объекта createLeague,
        // который разделяет playerList на отдельные списки для каждой лиги и добавляет их в EnumMap leagueList.
        createLeague.createLeagueList(leagueList, playerList);
       return leagueList;
    }

    public void print(){
        System.out.println(createObject());
    }
}