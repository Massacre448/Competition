package ING.onlinegame.model;

public class Clan implements Comparable<Clan> {
    private int numberOfPlayers;
    private int points;

    public Clan() {
    }

    public Clan(int numberOfPlayers, int points) {
        this.numberOfPlayers = numberOfPlayers;
        this.points = points;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(Clan o) {
        int result = Integer.compare(this.points, o.points);

        if (result == 0) {
            // If two clans have the same number of points, prioritize the one with fewer (better) players
            result = Integer.compare(o.numberOfPlayers, this.numberOfPlayers);
        }

        return result;
    }

    @Override
    public String toString() {
        return "Clan{" +
                "numberOfPlayers=" + numberOfPlayers +
                ", points=" + points +
                '}';
    }
}
