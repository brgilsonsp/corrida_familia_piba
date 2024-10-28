package br.org.piba.sporting_event_race.service;

import br.org.piba.sporting_event_race.model.enumaration.ClassificationTypeEnum;

public interface DefinitionClassificationTypeService {

    ClassificationTypeEnum verifyType(String gender, String ageRange);
}
