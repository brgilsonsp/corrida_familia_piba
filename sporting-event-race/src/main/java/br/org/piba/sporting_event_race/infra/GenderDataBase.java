package br.org.piba.sporting_event_race.infra;


import br.org.piba.sporting_event_race.model.enumaration.GenderEnum;

import java.util.ArrayList;
import java.util.List;

public class GenderDataBase {

    private static final List<GenderEnum> GENDER_ENUMS;

    static {
        GENDER_ENUMS = new ArrayList<>();
        GENDER_ENUMS.add(GenderEnum.FEMALE);
        GENDER_ENUMS.add(GenderEnum.MALE);
    }

    public List<GenderEnum> getGenders(){
        return GENDER_ENUMS;
    }
}
