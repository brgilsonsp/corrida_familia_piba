package br.org.piba.sporting_event_race.service;

import br.org.piba.sporting_event_race.model.domain.AthleteData;
import br.org.piba.sporting_event_race.model.dto.ClassificationDTO;
import br.org.piba.sporting_event_race.model.enumaration.StatusTimerEnum;

import java.util.*;

public class ClassificationDefinitionServiceImpl implements ClassificationDefinitionService{

    public static final int POSITION_ZERO = 0;

    @Override
    public List<ClassificationDTO> makeClassification(final Map<StatusTimerEnum, List<AthleteData>> athletes) {
        athletes.get(StatusTimerEnum.WITH_TIMER).sort(Comparator.comparing(AthleteData::totalRaceTime));
        List<ClassificationDTO> classifications = new ArrayList<>();
        for (int i = 0; i < athletes.get(StatusTimerEnum.WITH_TIMER).size(); i++) {
            AthleteData data = athletes.get(StatusTimerEnum.WITH_TIMER).get(i);
            classifications
                    .add(new ClassificationDTO(i+1, data.getName(), data.getFormattedTotalRaceTime()));
        }
        for(AthleteData data : athletes.get(StatusTimerEnum.NO_TIMER)){
            classifications
                    .add(new ClassificationDTO(POSITION_ZERO, data.getName(), data.getFormattedTotalRaceTime()));
        }

        return classifications;
    }

    @Override
    public Map<StatusTimerEnum, List<AthleteData>> segregateListAthletes(List<AthleteData> originList) {
        List<AthleteData> athletesWithTimer = new ArrayList<>();
        List<AthleteData> athletesNoTimer = new ArrayList<>();
        for (AthleteData data : originList) {
            if (data.totalRaceTime().isZero()) {
                athletesNoTimer.add(data);
            } else {
                athletesWithTimer.add(data);
            }
        }
        Map<StatusTimerEnum, List<AthleteData>> mapSegregate = new HashMap<>();
        mapSegregate.put(StatusTimerEnum.WITH_TIMER, athletesWithTimer);
        mapSegregate.put(StatusTimerEnum.NO_TIMER, athletesNoTimer);
        return mapSegregate;
    }
}
