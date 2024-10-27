package br.org.piba.sporting_event_race.config;

import br.org.piba.sporting_event_race.repository.AthleteDataRepository;
import br.org.piba.sporting_event_race.repository.SegmentRepository;
import br.org.piba.sporting_event_race.service.AthleteService;
import br.org.piba.sporting_event_race.service.SegmentService;
import br.org.piba.sporting_event_race.service.TimingAthleteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfiguration {

    @Bean
    public AthleteDataRepository getAthleteDataRepository(){
        return new AthleteDataRepository();
    }

    @Bean
    public SegmentRepository getAgeRangeDataBase(){
        return new SegmentRepository();
    }

    @Bean
    public TimingAthleteService getTimingService(AthleteDataRepository repository){
        return new TimingAthleteService(repository);
    }

    @Bean
    public AthleteService getAthleteService(AthleteDataRepository repository){
        return new AthleteService(repository);
    }

    @Bean
    public SegmentService getSegmentService(SegmentRepository repository){
        return new SegmentService(repository);
    }
}
