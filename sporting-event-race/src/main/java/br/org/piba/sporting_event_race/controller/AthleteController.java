package br.org.piba.sporting_event_race.controller;

import br.org.piba.sporting_event_race.model.dto.AthleteNumberDTO;
import br.org.piba.sporting_event_race.model.dto.AthletesDTO;
import br.org.piba.sporting_event_race.model.dto.AthleteFullNameRegisterDTO;
import br.org.piba.sporting_event_race.service.AthleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("athlete")
public class AthleteController {

    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public ResponseEntity<AthletesDTO<AthleteFullNameRegisterDTO>> getFullName(@RequestParam("start_name") String startName){
        return ResponseEntity.ok(athleteService.getListFullName(startName));
    }

    @PutMapping
    public ResponseEntity<AthleteNumberDTO> addNumber(@RequestBody AthleteNumberDTO athleteNumberDTO){
        return ResponseEntity.ok(this.athleteService.addNumber(athleteNumberDTO));

    }
}
