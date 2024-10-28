package br.org.piba.sporting_event_race.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Duration;

public record ClassificationDTO(@JsonProperty("posicao") int position,
                                @JsonProperty("nome_completo_atleta") String athleteFullName,
                                @JsonProperty("tempo_corrida") String totalRaceTime) {
}
