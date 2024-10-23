package br.org.piba.sporting_event_race.repository;

import br.org.piba.sporting_event_race.model.domain.AthleteData;
import br.org.piba.sporting_event_race.model.domain.Gender;

import java.time.LocalDate;
import java.util.*;

public class AthleteDataRepository {

    private final Map<UUID, AthleteData> ATHLETES;

    public AthleteDataRepository() {
        ATHLETES = new AthleteDataBase().getAthletes();
    }

    public Optional<AthleteData> getAthleteByNumber(final int number){
        return ATHLETES.values().stream()
                .filter(athlete -> athlete.getNumber() == number)
                .findFirst();
    }

    public Optional<AthleteData> getAthleteById(final UUID id){
        return Optional.ofNullable(ATHLETES.get(id));
    }

    public Optional<AthleteData> update(final AthleteData athlete){
        return Optional.ofNullable(ATHLETES.replace(athlete.getId(), athlete));
    }

    public List<AthleteData> getListBy(final String startName){
        return ATHLETES.values().stream()
                .filter(athlete -> athlete.getName().toLowerCase().startsWith(startName.toLowerCase()))
                .toList();
    }

    public List<AthleteData> getListBy(final Gender gender){
        if(Objects.isNull(gender)){
            return List.of();
        }

        return ATHLETES.values().stream()
                .filter(athlete -> gender.equals(athlete.getGender()))
                .toList();
    }

    public List<AthleteData> getListBy(final int minAge, final int maxAge){
        return ATHLETES.values().stream()
                .filter(athlete -> isAgeRange(athlete.getBirthDate(), minAge, maxAge))
                .toList();
    }

    public List<AthleteData> getListBy(final int minAge, final int maxAge, final Gender gender){
        return ATHLETES.values().stream()
                .filter(athlete -> gender.equals(athlete.getGender()))
                .filter(athlete -> isAgeRange(athlete.getBirthDate(), minAge, maxAge))
                .toList();
    }

    private boolean isAgeRange(final LocalDate birthDate, final int min, final int max){
        final int currentYear = LocalDate.now().getYear();
        final int athleteAge = currentYear - birthDate.getYear();
        return athleteAge >= min && athleteAge <= max;
    }


}
