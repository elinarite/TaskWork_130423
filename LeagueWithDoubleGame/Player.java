package TaskWorkHomework2.LeagueWithDoubleGame;

public class Player {

    private String name;
    private int PlayerNumber;
    private double score;

    public Player() {
    }
// TODO не ясно зачем игроку имя, ведь ты используешь тольок номер, наверное лучше убрать
    public Player(String name, int playerNumber, double score) {
        this.name = name;
        PlayerNumber = playerNumber;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerNumber() {
        return PlayerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        PlayerNumber = playerNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + PlayerNumber +
                ", score: " + score +
                "\n";
    }
}