package br.org.piba.sporting_event_race.infra;

import br.org.piba.sporting_event_race.model.domain.AgeRange;
import br.org.piba.sporting_event_race.model.enumaration.RangeAgeDefinitionEnum;

import java.util.HashMap;
import java.util.Map;

public class AgeRangeDataBase {

    private static final Map<RangeAgeDefinitionEnum, AgeRange> RANGES;
    static {
        RANGES = new HashMap<>();
        RANGES.put(RangeAgeDefinitionEnum.SIX_TO_SEVEN, new AgeRange(6,7));
        RANGES.put(RangeAgeDefinitionEnum.EIGHT_TO_TWELVE, new AgeRange(8,12));
        RANGES.put(RangeAgeDefinitionEnum.THIRTEEN_TO_FIFTEEN, new AgeRange(13,15));
        RANGES.put(RangeAgeDefinitionEnum.SIXTEEN_TO_TWENTY, new AgeRange(16,20));
        RANGES.put(RangeAgeDefinitionEnum.TWENTY_ONE_TO_THIRTY, new AgeRange(21,20));
        RANGES.put(RangeAgeDefinitionEnum.THIRTY_ONE_TO_FOURTH, new AgeRange(31,40));
        RANGES.put(RangeAgeDefinitionEnum.FOURTH_ONE_TO_FIFTH, new AgeRange(41,50));
        RANGES.put(RangeAgeDefinitionEnum.FIFTH_ONE_TO_SIXTH, new AgeRange(51,60));
        RANGES.put(RangeAgeDefinitionEnum.SIXTH_ONE_OR_MORE, new AgeRange(61,200));
    }

    public Map<RangeAgeDefinitionEnum, AgeRange> getByRanges(){
        return RANGES;
    }
}
