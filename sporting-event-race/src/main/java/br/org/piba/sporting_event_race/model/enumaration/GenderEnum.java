package br.org.piba.sporting_event_race.model.enumaration;

import br.org.piba.sporting_event_race.exception.GenderNotFoundException;

import java.util.Arrays;

public enum GenderEnum {

    MALE("Masculino"),
    FEMALE("Feminino");

    private final String value;

    GenderEnum(String genderName) {
        this.value = genderName;
    }

    public String getValue() {
        return value;
    }

    public static GenderEnum getEnum(final String gender){
        return Arrays.stream(GenderEnum.values()).filter(e -> e.getValue().equals(gender))
                .findFirst()
                .orElseThrow(() -> new GenderNotFoundException("Sexo informado não existe: " + gender));
    }
}
