package br.org.piba.sporting_event_race.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Classifications(@JsonProperty("dados") List<Classification> classifications) {
}
