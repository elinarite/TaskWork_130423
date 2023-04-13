package TaskWorkHomework2.LeagueWithDoubleGame;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Game {

    /**
     * Метод createObject создает и инициализирует EnumMap<League, List<Player>> leagueList,
     * используя CreateLeague и CreateGame, которые создают список игроков и игры.
     */
    // TODO - подумать над названием
    private EnumMap<League, List<Player>> createObject() {
        //Сначала создается пустой список игроков playerList
        List<Player> playerList = new ArrayList<>();
        //Затем создается пустой EnumMap<League, List<Player>> leagueList, используя конструктор EnumMap с параметром League.class.
        EnumMap<League, List<Player>> leagueList = new EnumMap<>(League.class);

        CreateLeague createLeague = new CreateLeague();
        CreateGame createGame = new CreateGame();

        // TODO - "Сначала вызывается метод createLeague у объекта createLeague," - неинформативный комментарий, это итак очевидно
        //Сначала вызывается метод createLeague у объекта createLeague,
        // который заполняет playerList пятью игроками
        //TODO - здесь лучше использовать статический метод.
        // лучше группировать методы по смыслу.
        // 1-я группа методов - которые создают лиги и игроков
        // 2-я - которая играет игры
        // вышло у тебя маcсло маслянное "createLeague.createLeague"
        // должно быт что то вроде Service.createLeague
        createLeague.createLeague(playerList);

        //вызывает метод game у объекта createGame, который создает игры между игроками в playerList
        //Затем вызывается метод doubleGame у объекта createGame,
        // который создает дополнительные игры между игроками в playerList
        //TODO - лучше разделять на два вызова, тк читаемость кода снижается
        // TODO - переделать программу, таким образом:
        // - в каждой лиге должны создаваться отдельные игроки, как кобъекты
        // - соответсвенно у каждого игрока свой уникальный номер в рамках всех лиг, те от 1 до 20
        createGame.doubleGame(createGame.game(playerList));

        //Затем вызывается метод createLeagueList у объекта createLeague,
        // который разделяет playerList на отдельные списки для каждой лиги и добавляет их в EnumMap leagueList.
        // TODO - не забывай форматить код
        createLeague.createLeagueList(leagueList, playerList);
       return leagueList;
    }

    public void print(){
        // TODO - сделай красивую распечатку
        System.out.println(createObject());
    }
}