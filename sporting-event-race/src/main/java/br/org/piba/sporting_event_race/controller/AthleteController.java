package br.org.piba.sporting_event_race.controller;

import br.org.piba.sporting_event_race.model.dto.AthleteFullNameRegisterDTO;
import br.org.piba.sporting_event_race.model.dto.AthleteNumberDTO;
import br.org.piba.sporting_event_race.model.dto.ListDataDTO;
import br.org.piba.sporting_event_race.service.AthleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atletas")
public class AthleteController {

    private final AthleteService athleteServiceMock;

    public AthleteController(AthleteService athleteServiceMock) {
        this.athleteServiceMock = athleteServiceMock;
    }

    @GetMapping
    public ResponseEntity<ListDataDTO<AthleteFullNameRegisterDTO>> getFullName(@RequestParam("start_name") String startName){
        final List<AthleteFullNameRegisterDTO> listFullName = athleteServiceMock.getListFullName(startName);
        return ResponseEntity.ok(new ListDataDTO(listFullName));
    }

    @PutMapping
    public ResponseEntity<AthleteNumberDTO> addNumber(@RequestBody AthleteNumberDTO athleteNumberDTO){
        return ResponseEntity.ok(this.athleteServiceMock.addNumber(athleteNumberDTO));

    }
}
