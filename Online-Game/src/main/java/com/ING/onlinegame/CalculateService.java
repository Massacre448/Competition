package com.ING.onlinegame;

import com.ING.onlinegame.model.Clan;
import com.ING.onlinegame.model.Group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculateService {

    private Clan findBestFitClan(List<Clan> clans, Set<Clan> usedClans, int remainingSpots) {
        Clan bestFitClan = null;
        for (Clan clan : clans) {
            if (usedClans.contains(clan)) {
                continue;
            }
            if (clan.getNumberOfPlayers() <= remainingSpots &&
                    (bestFitClan == null ||
                            clan.getPoints() > bestFitClan.getPoints() ||
                            (clan.getPoints() == bestFitClan.getPoints() && clan.getNumberOfPlayers() < bestFitClan.getNumberOfPlayers()))) {
                bestFitClan = clan;
            }
        }
        return bestFitClan;
    }

    public List<Group> calculate(int m, List<Clan> clans) {
        List<Group> order = new ArrayList<>();
        Set<Clan> usedClans = new HashSet<>();

        while (usedClans.size() < clans.size()) {
            Group group = new Group();
            int remainingSpots = m;

            while (true) {
                Clan bestFitClan = findBestFitClan(clans, usedClans, remainingSpots);
                if (bestFitClan == null) {
                    break;
                }
                group.getClans().add(bestFitClan);
                usedClans.add(bestFitClan);
                remainingSpots -= bestFitClan.getNumberOfPlayers();
            }

            order.add(group);
        }

        return order;
    }
}
