package br.org.piba.sporting_event_race.controller;

import br.org.piba.sporting_event_race.model.dto.SegmentDTO;
import br.org.piba.sporting_event_race.service.SegmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("segment")
public class SegmentController {

    private final SegmentService service;

    public SegmentController(SegmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<SegmentDTO> getSegments(){
        return ResponseEntity.ok(service.getSegments());
    }
}
