package ING.atmservice.service;

import ING.atmservice.model.ATM;
import ING.atmservice.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AtmService {

    private static final Map<String, Integer> REQUEST_PRIORITY_MAP = new HashMap<>();

    static {
        REQUEST_PRIORITY_MAP.put("FAILURE_RESTART", 1);
        REQUEST_PRIORITY_MAP.put("SIGNAL_LOW", 2);
        REQUEST_PRIORITY_MAP.put("PRIORITY", 3);
        REQUEST_PRIORITY_MAP.put("STANDARD", 4);
    }

    private int getRequestPriority(String requestType) {
        return REQUEST_PRIORITY_MAP.getOrDefault(requestType, Integer.MAX_VALUE);
    }

    public List<ATM> calculateOrder(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return Collections.emptyList();
        }

        tasks.sort(Comparator
                .comparingInt(Task::getRegion)
                .thenComparing((Task task) -> getRequestPriority(task.getRequestType()))
                .thenComparing(Task::getAtmId, Comparator.reverseOrder()));

        Set<ATM> orderedAtmsSet = new LinkedHashSet<>();
        for (Task task : tasks) {
            orderedAtmsSet.add(new ATM(task.getRegion(), task.getAtmId()));
        }

        return new ArrayList<>(orderedAtmsSet);
    }



}