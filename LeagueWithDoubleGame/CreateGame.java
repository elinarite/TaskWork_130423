package TaskWorkHomework2.LeagueWithDoubleGame;

import java.util.Collections;
import java.util.List;
public class CreateGame {

    /**
     * Этот код определяет метод с именем game, который принимает
     * список объектов Player в качестве входных данных и имитирует совпадения
     * между всеми парами игроков в списке. Он возвращает обновленный список объектов Player.
     * Метод использует вложенный цикл для перебора всех возможных пар игроков.
     * Для каждой пары игроков вызывается метод playMatch для имитации матча между ними.
     * После моделирования всех матчей возвращается обновленный список игроков.
     */
    // TODO - два вопроса:
    // 1. Зачем тут протектед?
    // 2. зачем перемешивать игроков? Ведь от перемены их положения в группе ничего не меняется
    protected List<Player> game(List<Player> players) {
          Collections.shuffle(players);
            for (int i = 0; i < League.values().length; i++) {
                for (int j = i + 1; j < League.values().length; j++) {
                    playMatch(players.get(i), players.get(j));
                }
            }
        return players;
    }

    //TODO -  doubleGame? "Двойная игра"? Лучше назвать playAdditionalGames
    /**
     * Этот код определяет метод с именем doubleGame,
     * который принимает в качестве входных данных список объектов Player и имитирует
     * матчи между всеми парами игроков, имеющих одинаковый счет. Он возвращает обновленный список объектов Player.
     * Метод использует вложенный цикл для перебора всех возможных пар игроков.
     * Если очки двух сравниваемых игроков равны, вызывается метод playMatch для имитации матча между ними.
     * После моделирования всех матчей возвращается обновленный список игроков.
     */
    protected List<Player> doubleGame(List<Player> players) {
        for (int i = 0; i < League.values().length; i++) {
            for (int j = 0; j < League.values().length; j++) {
                if (players.get(i).getScore() == players.get(j).getScore()) {
                    playMatch(players.get(i), players.get(j));
                }
            }
        }
        return players;
    }

    /**
     * Этот код определяет метод с именем playMatch, который принимает два объекта Player
     * в качестве входных данных и имитирует совпадение между ними.
     * Исход матча определяется случайным образом с помощью метода Math.random(),
     * который возвращает случайное число от 0 до 1.
     * Если первый игрок p1 набирает больше очков, чем второй игрок p2,
     * метод ничего не делает. Если второй игрок p2 набирает больше очков,
     * чем первый игрок p1, счет второго игрока обновляется путем добавления переменной winPoints,
     * для которой установлено значение 1. Если оба игрока набирают одинаковое количество очков,
     * очки обоих игроков обновляются путем добавления переменной drawPoints. , который установлен на 0,5.
     */
    //TODO - проверить логику присвоения победы, я тут победы игрока1 вообще не вижу
    // игроку 2 почему то присваивается счет игрока1
    private void playMatch(Player p1, Player p2) {
        // TODO - эти очки лучше объявить константой
        double winPoints = 1;
        double drawPoints = 0.5;
        double p1Score = Math.random();
        double p2Score = 1 - p1Score;
        if (p1Score > p2Score) {
        } else if (p2Score > p1Score) {
            p2.setScore(p1.getScore() + winPoints);
        } else {
            p1.setScore(p1.getScore() + drawPoints);
            p2.setScore(p1.getScore() + drawPoints);
        }
    }
}