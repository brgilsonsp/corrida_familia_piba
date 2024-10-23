package br.org.piba.sporting_event_race.model.domain;

import java.util.List;

public record Segment(List<Gender> genders,
                      List<AgeRange.RangeAgeDefinition> rangeAge) {
}
