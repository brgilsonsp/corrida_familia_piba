package br.org.piba.sporting_event_race.infra;

import br.org.piba.sporting_event_race.model.domain.AthleteData;
import br.org.piba.sporting_event_race.model.enumaration.GenderEnum;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AthleteDataBase {

    private static final Map<String, GenderEnum> NAME_GENDER_MAP;
    private static final GenderEnum MALE = GenderEnum.MALE;
    private static final GenderEnum FEMALE = GenderEnum.FEMALE;
    private static final int MIN_AGE = 6;
    private static final int MAX_AGE = 70;
    private final static Map<UUID, AthleteData> ATHLETES;

    static {
        NAME_GENDER_MAP = new HashMap<>();
        // Adicionando nomes masculinos e seus respectivos gêneros
        NAME_GENDER_MAP.put("João Pedro Almeida Silva", MALE);
        NAME_GENDER_MAP.put("Lucas Henrique Oliveira Souza", MALE);
        NAME_GENDER_MAP.put("Gabriel Ferreira Costa", MALE);
        NAME_GENDER_MAP.put("Thiago Rodrigues Lima", MALE);
        NAME_GENDER_MAP.put("Matheus Santos Pereira", MALE);
        NAME_GENDER_MAP.put("Leonardo Alves Ribeiro", MALE);
        NAME_GENDER_MAP.put("Rafael Cunha Carvalho", MALE);
        NAME_GENDER_MAP.put("Bruno Mendes Araújo", MALE);
        NAME_GENDER_MAP.put("Diego Nogueira Barbosa", MALE);
        NAME_GENDER_MAP.put("Felipe Castro Gomes", MALE);
        NAME_GENDER_MAP.put("André Martins Figueira", MALE);
        NAME_GENDER_MAP.put("Gustavo Moraes Machado", MALE);
        NAME_GENDER_MAP.put("Ricardo Nascimento Correia", MALE);
        NAME_GENDER_MAP.put("Daniel Teixeira Monteiro", MALE);
        NAME_GENDER_MAP.put("Eduardo Araújo Fonseca", MALE);
        // Adicionando nomes femininos e seus respectivos gêneros
        NAME_GENDER_MAP.put("Maria Clara Fernandes Lima", FEMALE);
        NAME_GENDER_MAP.put("Ana Beatriz Oliveira Silva", FEMALE);
        NAME_GENDER_MAP.put("Letícia Martins Costa", FEMALE);
        NAME_GENDER_MAP.put("Júlia Santos Carvalho", FEMALE);
        NAME_GENDER_MAP.put("Camila Ferreira Sousa", FEMALE);
        NAME_GENDER_MAP.put("Larissa Almeida Pereira", FEMALE);
        NAME_GENDER_MAP.put("Isabela Souza Oliveira", FEMALE);
        NAME_GENDER_MAP.put("Mariana Cunha Ribeiro", FEMALE);
        NAME_GENDER_MAP.put("Bianca Rodrigues Nogueira", FEMALE);
        NAME_GENDER_MAP.put("Fernanda Mendes Castro", FEMALE);
        NAME_GENDER_MAP.put("Rafaela Barbosa Teixeira", FEMALE);
        NAME_GENDER_MAP.put("Aline Nogueira Araújo", FEMALE);
        NAME_GENDER_MAP.put("Vanessa Lima Fonseca", FEMALE);
        NAME_GENDER_MAP.put("Tatiane Gomes Nascimento", FEMALE);
        NAME_GENDER_MAP.put("Juliana Figueira Monteiro", FEMALE);

        ATHLETES = new HashMap<>();
        AthleteDataBase.NAME_GENDER_MAP
                .forEach((name, gender) -> {
                    AthleteData data = buildAthlete(name, gender);
                    ATHLETES.put(data.getId(), data);
                });

    }

    private static AthleteData buildAthlete(final String name, final GenderEnum genderEnum){
        return new AthleteData(name, genderEnum, getRandomBirthDate());
    }

    private static LocalDate getRandomBirthDate() {
        int currentYear = LocalDate.now().getYear();
        int randomYear = currentYear - (int) (Math.random() * (MAX_AGE - MIN_AGE) + MAX_AGE);
        Month randomMonth = Month.of((int) (Math.random() * 12) + 1); // Random month between 1 and 12
        int randomDay = (int) (Math.random() * 28) + 1; // Random day between 1 and 28 to avoid invalid days
        return LocalDate.of(randomYear, randomMonth, randomDay);
    }

    public Map<UUID, AthleteData> getAthletes(){
        return ATHLETES;
    }
}
