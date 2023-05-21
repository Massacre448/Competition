package ING.atmservice.controller;

import ING.atmservice.model.ATM;
import ING.atmservice.model.Task;
import ING.atmservice.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atms")
public class AtmController {

    private final AtmService atmService;

    @Autowired
    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    @PostMapping("/calculateOrder")
    public ResponseEntity<List<ATM>> calculateOrder(@RequestBody List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<ATM> orderedAtms = atmService.calculateOrder(tasks);
        return new ResponseEntity<>(orderedAtms, HttpStatus.OK);
    }
}
