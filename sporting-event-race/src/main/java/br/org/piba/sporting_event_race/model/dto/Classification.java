package br.org.piba.sporting_event_race.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Classification(@JsonProperty("posicao") int position,
                             @JsonProperty("nome_completo_atleta") String athleteFullName,
                             @JsonProperty("tempo_corrida") int totalRaceTime) {
}
