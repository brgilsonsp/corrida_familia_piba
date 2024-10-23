package br.org.piba.sporting_event_race.service;

import br.org.piba.sporting_event_race.model.domain.AgeRange;
import br.org.piba.sporting_event_race.model.domain.Gender;
import br.org.piba.sporting_event_race.model.domain.Segment;
import br.org.piba.sporting_event_race.model.dto.SegmentDTO;
import br.org.piba.sporting_event_race.repository.SegmentRepository;

import java.util.List;

public class SegmentService {

    private final SegmentRepository repository;

    public SegmentService(SegmentRepository repository) {
        this.repository = repository;
    }

    public SegmentDTO getSegments(){
        final Segment segments = repository.getSegments();
        final List<String> ranges = segments.rangeAge().stream()
                .map(AgeRange.RangeAgeDefinition::value).toList();
        final List<String> genders = segments.genders().stream()
                .map(Gender::getValue).toList();

        return new SegmentDTO(genders, ranges);
    }
}
