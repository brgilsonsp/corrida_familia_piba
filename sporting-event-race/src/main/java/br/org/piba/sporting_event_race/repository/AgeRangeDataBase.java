package br.org.piba.sporting_event_race.repository;

import br.org.piba.sporting_event_race.model.domain.AgeRange;

import java.util.HashMap;
import java.util.Map;

public class AgeRangeDataBase {

    private static final Map<AgeRange.RangeAgeDefinition, AgeRange> RANGES;
    static {
        RANGES = new HashMap<>();
        RANGES.put(AgeRange.RangeAgeDefinition.SIX_TO_SEVEN, new AgeRange(6,7));
        RANGES.put(AgeRange.RangeAgeDefinition.EIGHT_TO_TWELVE, new AgeRange(8,12));
        RANGES.put(AgeRange.RangeAgeDefinition.THIRTEEN_TO_FIFTEEN, new AgeRange(13,15));
        RANGES.put(AgeRange.RangeAgeDefinition.SIXTEEN_TO_TWENTY, new AgeRange(16,20));
        RANGES.put(AgeRange.RangeAgeDefinition.TWENTY_ONE_TO_THIRTY, new AgeRange(21,20));
        RANGES.put(AgeRange.RangeAgeDefinition.THIRTY_ONE_TO_FOURTH, new AgeRange(31,40));
        RANGES.put(AgeRange.RangeAgeDefinition.FOURTH_ONE_TO_FIFTH, new AgeRange(41,50));
        RANGES.put(AgeRange.RangeAgeDefinition.FIFTH_ONE_TO_SIXTH, new AgeRange(51,60));
        RANGES.put(AgeRange.RangeAgeDefinition.SIXTH_ONE_OR_MORE, new AgeRange(61,200));
    }

    public Map<AgeRange.RangeAgeDefinition, AgeRange> getByRanges(){
        return RANGES;
    }
}
