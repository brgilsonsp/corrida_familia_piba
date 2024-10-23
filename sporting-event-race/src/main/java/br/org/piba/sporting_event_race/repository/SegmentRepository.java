package br.org.piba.sporting_event_race.repository;

import br.org.piba.sporting_event_race.model.domain.AgeRange;
import br.org.piba.sporting_event_race.model.domain.Gender;
import br.org.piba.sporting_event_race.model.domain.Segment;

import java.util.List;
import java.util.Map;

public class SegmentRepository {
    private final List<Gender> GENDERS;
    private final Map<AgeRange.RangeAgeDefinition, AgeRange> RANGES;

    public SegmentRepository() {
        GENDERS = new GenderDataBase().getGenders();
        RANGES = new AgeRangeDataBase().getByRanges();
    }

    public Segment getSegments(){
        return new Segment(GENDERS, RANGES.keySet().stream().toList());
    }
}
