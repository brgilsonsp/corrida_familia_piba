package br.org.piba.sporting_event_race.repository;

import br.org.piba.sporting_event_race.infra.AgeRangeDataBase;
import br.org.piba.sporting_event_race.infra.GenderDataBase;
import br.org.piba.sporting_event_race.model.domain.AgeRange;
import br.org.piba.sporting_event_race.model.domain.Segment;
import br.org.piba.sporting_event_race.model.enumaration.GenderEnum;
import br.org.piba.sporting_event_race.model.enumaration.RangeAgeDefinitionEnum;

import java.util.List;
import java.util.Map;

public class SegmentMockRepository implements SegmentRepository{
    private final List<GenderEnum> GENDERS;
    private final Map<RangeAgeDefinitionEnum, AgeRange> RANGES;

    public SegmentMockRepository() {
        GENDERS = new GenderDataBase().getGenders();
        RANGES = new AgeRangeDataBase().getByRanges();
    }

    @Override
    public Segment getSegments(){
        return new Segment(GENDERS, RANGES.keySet().stream().toList());
    }

    @Override
    public AgeRange getAgeRangeBy(final RangeAgeDefinitionEnum rangeAgeDefinition) {
        return RANGES.get(rangeAgeDefinition);
    }
}
