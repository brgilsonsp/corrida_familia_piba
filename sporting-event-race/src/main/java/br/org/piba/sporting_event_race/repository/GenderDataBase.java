package br.org.piba.sporting_event_race.repository;

import br.org.piba.sporting_event_race.model.domain.Gender;

import java.util.ArrayList;
import java.util.List;

public class GenderDataBase {

    private static final List<Gender> GENDERS;

    static {
        GENDERS = new ArrayList<>();
        GENDERS.add(Gender.FEMALE);
        GENDERS.add(Gender.MALE);
    }

    public List<Gender> getGenders(){
        return GENDERS;
    }
}
