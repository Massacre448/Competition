package ING.onlinegame.model;

import java.util.List;

public class Players {
    private int groupCount;
    private List<Clan> clans;

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public List<Clan> getClans() {
        return clans;
    }

    public void setClans(List<Clan> clans) {
        this.clans = clans;
    }

    @Override
    public String toString() {
        return "Players{" +
                "groupCount=" + groupCount +
                ", clans=" + clans +
                '}';
    }
}
