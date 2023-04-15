package TaskWorkHomework2.LeagueWithDoubleGame;

import java.util.*;

public class ServiceGame {

    /**
     * константы WIN_POINTS и DRAW_POINTS, которые задают количество очков за победу и за ничью.
     */
    private static final double WIN_POINTS = 1;
    private static final double DRAW_POINTS = 0.5;

    /**
     * Это метод game, который получает в качестве аргумента
     * EnumMap<League, List<Player>> leagueList (список игроков каждой из 20 лиг) и
     * запускает циклы, чтобы каждый игрок из каждой лиги сыграл один матч с каждым другим игроком
     * из своей лиги. В итоге метод возвращает этот же список leagueList, но уже с результатами
     * всех сыгранных матчей.
     */
    protected void game(EnumMap<League, List<Player>> leagueList) {
        for (Map.Entry<League, List<Player>> entry : leagueList.entrySet()) {
            List<Player> leaguePlayers = entry.getValue();
            for (int i = 0; i < League.values().length; i++) {
                for (int j = i + 1; j < League.values().length; j++) {
                    playMatch(leaguePlayers.get(i), leaguePlayers.get(j));
                }
            }
        }
    }

    /**
     * Этот метод playAdditionalGames предназначен для игры дополнительных матчей между игроками,
     * которые имеют одинаковое количество очков. Он проходит по списку игроков для каждой лиги
     * в leagueList, затем для каждой пары игроков проверяет,
     * имеют ли они одинаковое количество очков, и если да, то запускает метод
     * playMatch для проведения матча между этими игроками.
     */
    protected void playAdditionalGames(EnumMap<League, List<Player>> leagueList) {
        for (Map.Entry<League, List<Player>> entry : leagueList.entrySet()) {
            List<Player> leaguePlayers = entry.getValue();
            for (int i = 0; i < League.values().length; i++) {
                for (int j = i + 1; j < League.values().length; j++) {
                    if (leaguePlayers.get(i).getScore() == leaguePlayers.get(j).getScore()) {
                        playMatch(leaguePlayers.get(i), leaguePlayers.get(j));
                    }
                }
            }
        }
    }

    /**
     * метод playMatch, который используется для проведения матча между двумя игроками.
     * Метод использует генератор случайных чисел (Math.random()) для определения результата матча.
     * Если случайное число меньше 0.33, то первый игрок побеждает, ему присваиваются очки за победу
     * Если случайное число находится между 0.33 и 0.66, то матч заканчивается вничью,
     * каждый игрок получает по половине очков за ничью.
     * Если случайное число больше 0.66, то побеждает второй игрок,
     * и ему присваиваются очки за победу.
     */
    private void playMatch(Player p1, Player p2) {
        double result = Math.random();
        if (result < 0.33) {
            p1.setScore(p1.getScore() + WIN_POINTS);
        } else if (result < 0.66 && result > 0.33) {
            p1.setScore(p1.getScore() + DRAW_POINTS);
            p2.setScore(p2.getScore() + DRAW_POINTS);
        } else if (result > 0.66) {
            p2.setScore(p2.getScore() + WIN_POINTS);
        }
    }

    /**
     * сортируется каждый список игроков по очкам, используя метод Collections.sort()
     * и компаратор Comparator.comparingInt(p -> -p.score), который сортирует по убыванию очков
     */
    protected EnumMap<League, List<Player>> sortMap(EnumMap<League, List<Player>> leagueList){
        for (List<Player> players : leagueList.values()) {
            Collections.sort(players, Comparator.comparingDouble(p -> -p.getScore()));
        }
        return leagueList;
    }
}