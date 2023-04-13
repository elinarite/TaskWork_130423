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
public class ServiceLeague {
    //flatMap
    /**
     * количество объектов Player
     */
    private static final int NUM_PLAYERS_PER_LEAGUE = 5;

    /**
     * количества игроков в списках лиг.
     */
    private static final int NUM_PLAYERS_IN_LEAGUE_LIST = 20;

    /**
     * Метод createLeague принимает Set <Player> в качестве входных
     * данных и добавляет к нему NUM_PLAYERS_IN_LEAGUE_LIST количества игроков в списках лиг..
     * Каждый объект Player инициализируется именем Player, уникальным номером игрока и нулевым счетом.
     */
    protected Set<Player> createLeague(Set<Player> playerList) {
        for (int i = 1; i <= NUM_PLAYERS_IN_LEAGUE_LIST; i++) {
            playerList.add((Player) new Player("Player", i, 0));
        }
        return playerList;
    }

    /**
     Это метод createLeagueList, который используется для создания списка игроков в
     каждой лиге на основе переданного множества игроков.
     Метод использует EnumMap<League, List<Player>> leagueList,
     чтобы хранить списки игроков каждой лиги. В цикле while с помощью итератора iterator
     он проходит по множеству игроков playersList и добавляет каждого игрока в соответствующий
     список игроков в leagueList.
     */

    protected EnumMap<League, List<Player>> createLeagueList(EnumMap<League, List<Player>> leagueList, Set<Player> playersList) {
        Iterator<Player> iterator = playersList.iterator();
        while (iterator.hasNext()) {
            for (int i = 0; i < League.values().length; i++) {
                // получаем список игроков из leagueList
                List<Player> players = leagueList.get(League.values()[i]);
                // если список не создан, то создаем его и добавляем в leagueList
                if (players == null) {
                    players = new ArrayList<>();
                    leagueList.put(League.values()[i], players);
                }
                // добавляем игроков в список
                for (int j = 0; j < NUM_PLAYERS_PER_LEAGUE; j++) {
                    if (iterator.hasNext()) {
                        players.add(iterator.next());
                        iterator.remove();
                    }
                }
                // обновляем список игроков в leagueList
                leagueList.put(League.values()[i], players);
            }
        }
        return leagueList;
    }
}