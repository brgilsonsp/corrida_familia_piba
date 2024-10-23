package br.org.piba.sporting_event_race.controller;

import br.org.piba.sporting_event_race.model.dto.RegistersTimingDTO;
import br.org.piba.sporting_event_race.service.TimingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timing")
public class TimingController {
    private final TimingService timingService;

    public TimingController(TimingService timingService) {
        this.timingService = timingService;
    }

    @PostMapping
    public ResponseEntity<RegistersTimingDTO> addTiming(@RequestBody RegistersTimingDTO timingsDTO){
        return ResponseEntity.ok(timingService.addTimings(timingsDTO));
    }
}
