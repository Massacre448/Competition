package com.ING.atmservice.service;

import com.ING.atmservice.model.ATM;
import com.ING.atmservice.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AtmService {

    public List<ATM> calculateOrder(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return Collections.emptyList();
        }

        Map<ATM, Integer> atmWeights = tasks.stream()
                .collect(Collectors.toMap(task -> new ATM(task.getRegion(), task.getAtmId()),
                        task -> getRequestWeight(task.getRequestType()),
                        Integer::min));

        return atmWeights.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(ATM::getRegion).thenComparing(ATM::getAtmId)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int getRequestWeight(String requestType) {
        switch (requestType) {
            case "FAILURE_RESTART":
                return 1;
            case "PRIORITY":
                return 2;
            case "SIGNAL_LOW":
                return 3;
            case "STANDARD":
            default:
                return 4;
        }
    }
}
