package br.org.piba.sporting_event_race.model.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class AthleteData {

    private final UUID id;
    private final String name;
    private final Gender gender;
    private final LocalDate birthDate;
    private int number;
    private final LocalTime startTime;
    private LocalTime arrivalTime;
    private String operator;

    public AthleteData(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        id = UUID.randomUUID();
        startTime = LocalTime.now().minusHours(1);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public Duration totalRaceTime(){
        if(Objects.isNull(arrivalTime)){
            arrivalTime = LocalTime.now();
        }

        return Duration.between(startTime, arrivalTime);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AthleteData that = (AthleteData) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AthleteData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", number=" + number +
                ", startTime=" + startTime +
                ", arrivalTime=" + arrivalTime +
                ", operator='" + operator + '\'' +
                '}';
    }
}
