package ING.onlinegame.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Clan> clans = new ArrayList<>();

    public List<Clan> getClans() {
        return clans;
    }

    public void setClans(List<Clan> clans) {
        this.clans = clans;
    }

    @Override
    public String toString() {
        return "Group{" +
                "clans=" + clans +
                '}';
    }
}
