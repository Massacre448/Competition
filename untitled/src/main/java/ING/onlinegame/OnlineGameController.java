package ING.onlinegame;

import ING.onlinegame.model.Clan;
import ING.onlinegame.model.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/onlinegame")
public class OnlineGameController {

    private final CalculateService calculateService;

    @Autowired
    public OnlineGameController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<List<List<Clan>>> calculateOrder(@RequestBody Players players) {
        if (players == null || players.getClans().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<List<Clan>> order = calculateService.calculate(players.getGroupCount(), players.getClans());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
