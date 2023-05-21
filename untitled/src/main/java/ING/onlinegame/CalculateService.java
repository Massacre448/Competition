package ING.onlinegame;

import ING.onlinegame.model.Clan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CalculateService {

    public List<List<Clan>> calculate(int m, List<Clan> clans) {
        // Sort the clans according to the rules
        clans.sort(Comparator.comparing(Clan::getPoints).reversed()
                .thenComparing(Clan::getNumberOfPlayers));

        List<List<Clan>> order = new ArrayList<>(clans.size());

        for (Clan clan : clans) {
            boolean added = false;
            for (List<Clan> group : order) {
                int totalPlayers = group.stream().mapToInt(Clan::getNumberOfPlayers).sum();
                if (totalPlayers + clan.getNumberOfPlayers() <= m) {
                    group.add(clan);
                    added = true;
                    break;
                }
            }
            if (!added) {
                List<Clan> newGroup = new ArrayList<>();
                newGroup.add(clan);
                order.add(newGroup);
            }
        }

        return order;
    }
}
