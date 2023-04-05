package com.ING.onlinegame;

import com.ING.onlinegame.model.Group;
import com.ING.onlinegame.model.Players;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static Players readInputData(String inputFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(inputFilePath), Players.class);
    }

    public static void main(String[] args) {
        try {
            // Read input data from JSON file
            Players players = readInputData("example_request.json");

            // Calculate order
            CalculateService service = new CalculateService();
            List<Group> order = service.calculate(players.getGroupCount(), players.getClans());
            logger.info("Order: {}", order);
        } catch (IOException e) {
            logger.error("Error reading input data", e);
        }
    }
}
