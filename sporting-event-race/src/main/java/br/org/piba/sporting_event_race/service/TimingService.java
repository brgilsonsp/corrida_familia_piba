package br.org.piba.sporting_event_race.service;

import br.org.piba.sporting_event_race.model.domain.AthleteData;
import br.org.piba.sporting_event_race.model.dto.RegisterTimingDTO;
import br.org.piba.sporting_event_race.model.dto.RegistersTimingDTO;
import br.org.piba.sporting_event_race.repository.AthleteDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class TimingService {
    private final static Logger LOGGER= LoggerFactory.getLogger(TimingService.class);
    private final AthleteDataRepository repository;

    public TimingService(AthleteDataRepository repository) {
        this.repository = repository;
    }

    public RegistersTimingDTO addTimings(final RegistersTimingDTO timingsDTO){
        List<RegisterTimingDTO> registered = new ArrayList<>();
        timingsDTO.registersTiming()
                .stream()
                .map(this::mapperToAthleteData)
                .map(repository::update)
                .map(athleteData -> athleteData.orElseThrow(() -> new NoSuchElementException("Athlete not found")))
                .map(this::mapperToRegisterTimeDTO)
                .forEach(registered::add);

        return new RegistersTimingDTO(registered);
    }

    private AthleteData mapperToAthleteData(RegisterTimingDTO registerTimingDTO) {
        Optional<AthleteData> athleteByNumber = repository
                .getAthleteByNumber(registerTimingDTO.athleteNumber());
        if(athleteByNumber.isPresent()){
            athleteByNumber.get().setArrivalTime(registerTimingDTO.arrivalTime());
            athleteByNumber.get().setOperator(registerTimingDTO.operator());
            return athleteByNumber.get();
        }
        throw new NoSuchElementException("Athlete not found");
    }

    private RegisterTimingDTO mapperToRegisterTimeDTO(AthleteData athleteData) {

        return new RegisterTimingDTO(athleteData.getOperator(),
                athleteData.getNumber(),
                athleteData.getArrivalTime());
    }

}
