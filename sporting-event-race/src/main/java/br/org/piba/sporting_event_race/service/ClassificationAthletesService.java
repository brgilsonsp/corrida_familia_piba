package br.org.piba.sporting_event_race.service;

import br.org.piba.sporting_event_race.model.dto.ClassificationDTO;

import java.util.List;

public interface ClassificationAthletesService {

    List<ClassificationDTO> getClassificationByGender(String gender);

    List<ClassificationDTO> getClassificationByAgeRange(String ageRange);

    List<ClassificationDTO> getClassificationByGenderAndAgeRange(String gender, String ageRange);

    List<ClassificationDTO> getClassificationGeneral();
}
