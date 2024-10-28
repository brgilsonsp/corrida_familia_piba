package br.org.piba.sporting_event_race.controller;

import br.org.piba.sporting_event_race.model.dto.RegistersTimingDTO;
import br.org.piba.sporting_event_race.service.TimingAthleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cronometros")
public class TimingAthleteController {
    private final TimingAthleteService timingAthleteServiceImpl;

    public TimingAthleteController(TimingAthleteService timingAthleteServiceImpl) {
        this.timingAthleteServiceImpl = timingAthleteServiceImpl;
    }

    @PostMapping
    public ResponseEntity<RegistersTimingDTO> addTimingAthlete(@RequestBody RegistersTimingDTO timingsDTO){
        return ResponseEntity.ok(timingAthleteServiceImpl.addTimingToAthlete(timingsDTO));
    }
}
