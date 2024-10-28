package br.org.piba.sporting_event_race.service;

import br.org.piba.sporting_event_race.model.domain.Segment;
import br.org.piba.sporting_event_race.model.dto.SegmentDTO;
import br.org.piba.sporting_event_race.model.enumaration.RangeAgeDefinitionEnum;
import br.org.piba.sporting_event_race.model.enumaration.GenderEnum;
import br.org.piba.sporting_event_race.repository.SegmentRepository;

import java.util.List;

public class SegmentServiceImpl implements SegmentService{

    private final SegmentRepository repository;

    public SegmentServiceImpl(SegmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public SegmentDTO getSegments(){
        final Segment segments = repository.getSegments();
        final List<String> ranges = segments.rangeAge().stream()
                .map(RangeAgeDefinitionEnum::getValue).toList();
        final List<String> genders = segments.genderEnums().stream()
                .map(GenderEnum::getValue).toList();

        return new SegmentDTO(genders, ranges);
    }
}
