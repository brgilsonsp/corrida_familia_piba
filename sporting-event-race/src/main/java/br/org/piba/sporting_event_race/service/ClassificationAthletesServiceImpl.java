package br.org.piba.sporting_event_race.service;

import br.org.piba.sporting_event_race.model.domain.AgeRange;
import br.org.piba.sporting_event_race.model.domain.AthleteData;
import br.org.piba.sporting_event_race.model.dto.ClassificationDTO;
import br.org.piba.sporting_event_race.model.enumaration.GenderEnum;
import br.org.piba.sporting_event_race.model.enumaration.RangeAgeDefinitionEnum;
import br.org.piba.sporting_event_race.model.enumaration.StatusTimerEnum;
import br.org.piba.sporting_event_race.repository.AthleteDataRepository;
import br.org.piba.sporting_event_race.repository.SegmentRepository;

import java.util.*;

public class ClassificationAthletesServiceImpl implements ClassificationAthletesService{
    private final AthleteDataRepository athleteRepository;
    private final ClassificationDefinitionService classificationDefinitionService;
    private final SegmentRepository segmentRepository;

    public ClassificationAthletesServiceImpl(AthleteDataRepository athleteRepository,
                                             ClassificationDefinitionService classificationDefinitionService,
                                             SegmentRepository segmentRepository) {
        this.athleteRepository = athleteRepository;
        this.classificationDefinitionService = classificationDefinitionService;
        this.segmentRepository = segmentRepository;
    }

    public List<ClassificationDTO> getClassificationByGender(final String gender) {
        final GenderEnum genderEnum = GenderEnum.getEnum(gender);
        List<AthleteData> allAthletes = athleteRepository.getListBy(genderEnum);
        return getClassificationDTOS(allAthletes);
    }

    @Override
    public List<ClassificationDTO> getClassificationByAgeRange(String ageRange) {
        final AgeRange ageRangeObject = getAgeRange(ageRange);
        final List<AthleteData> allAthletes = athleteRepository.getListBy(ageRangeObject.initialAge(), ageRangeObject.limitAge());
        return getClassificationDTOS(allAthletes);
    }

    @Override
    public List<ClassificationDTO> getClassificationByGenderAndAgeRange(String gender, String ageRange) {
        final GenderEnum genderEnum = GenderEnum.getEnum(gender);
        final AgeRange ageRangeObject = getAgeRange(ageRange);
        final List<AthleteData> allAthletes = athleteRepository.getListBy(ageRangeObject.initialAge(), ageRangeObject.limitAge(), genderEnum);
        return getClassificationDTOS(allAthletes);
    }

    @Override
    public List<ClassificationDTO> getClassificationGeneral() {
        return getClassificationDTOS(athleteRepository.getListAll());
    }

    private List<ClassificationDTO> getClassificationDTOS(List<AthleteData> allAthletes) {
        Map<StatusTimerEnum, List<AthleteData>> listSegregated = classificationDefinitionService.segregateListAthletes(allAthletes);
        return classificationDefinitionService.makeClassification(listSegregated);
    }

    private AgeRange getAgeRange(String ageRange) {
        final RangeAgeDefinitionEnum ageDefinitionEnum = RangeAgeDefinitionEnum.getEnum(ageRange);
        return segmentRepository.getAgeRangeBy(ageDefinitionEnum);
    }
}
