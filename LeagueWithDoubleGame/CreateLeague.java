package TaskWorkHomework2.LeagueWithDoubleGame;

import java.util.*;

/**
 * //    - ИГРА
 * //Создать 4 лиги (энам)
 * //Класс Игрок
 * //Написать класс который создает по 5 игроков в каждой лиге
 * //Написать класс который проводит Игру Каждый с каждым внутри одной лиги
 * //Если победа то присваиваться 1 балл, ничья 0,5 проигрыш 0
 * //Если есть одинаковой кол-во баллов то эти игроки переигрывают
 * //Результат: Должны создаться 20 игроков , сыграть каждый с каждым в своей лиге
 * //и потом вывести на экран список начиная от победителя
 */
public class CreateLeague {
    //flatMap
    /**
     * NUM_PLAYERS_PER_LEAGUE - количество объектов Player
     */
    private static final int NUM_PLAYERS_PER_LEAGUE = 5;

    // TODO - Следующий апргрейд проекта - переделай код,
    //  чтобы у каждого игрока был уникальный номер во всех лигах

    /**
     * Метод createLeague принимает список List<Player> в качестве входных
     * данных и добавляет к нему NUM_PLAYERS_PER_LEAGUE количество объектов Player.
     * Каждый объект Player инициализируется именем Player, уникальным номером игрока и нулевым счетом.
     * @param playerList
     */
    protected void createLeague(List<Player> playerList) {
        for (int i = 1; i <= NUM_PLAYERS_PER_LEAGUE; i++) {
            playerList.add(new Player("Player", i, 0));
        }
    }

    /**
     * создает список игроков в каждой лиге и помещает его в EnumMap<League, List<Player>> leagueList.
     * Он принимает два аргумента: leagueList - EnumMap для хранения игроков в каждой лиге,
     * и playerList - список всех игроков.
     * Этот метод использует Collections.shuffle(playerList) для перемешивания
     * списка игроков перед его разделением на лиги. Затем он перебирает каждую лигу League.values()
     * и помещает перемешанный список игроков в каждую лигу, используя метод put EnumMap.
     */
    protected void createLeagueList(EnumMap<League, List<Player>> leagueList, List<Player> playerList) {
        for (int i = 0; i < League.values().length; i++) {
            Collections.shuffle(playerList);
            leagueList.put(League.values()[i], playerList);
        }
    }
}