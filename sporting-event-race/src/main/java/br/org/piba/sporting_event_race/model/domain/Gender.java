package br.org.piba.sporting_event_race.model.domain;

public enum Gender {

    MALE("Masculino"),
    FEMALE("Femino");

    private final String value;

    Gender(String genderName) {
        this.value = genderName;
    }

    public String getValue() {
        return value;
    }
}
