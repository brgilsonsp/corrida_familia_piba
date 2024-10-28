package br.org.piba.sporting_event_race.controller;

import br.org.piba.sporting_event_race.model.dto.ClassificationDTO;
import br.org.piba.sporting_event_race.model.dto.ListDataDTO;
import br.org.piba.sporting_event_race.model.enumaration.ClassificationTypeEnum;
import br.org.piba.sporting_event_race.service.ClassificationAthletesService;
import br.org.piba.sporting_event_race.service.DefinitionClassificationTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classificacoes")
public class ClassificationAthletesController {

    private final DefinitionClassificationTypeService definitionTypeClassification;
    private final ClassificationAthletesService classificationService;

    public ClassificationAthletesController(DefinitionClassificationTypeService definitionTypeClassification, ClassificationAthletesService classificationService) {
        this.definitionTypeClassification = definitionTypeClassification;
        this.classificationService = classificationService;
    }


    @GetMapping
    public ResponseEntity<ListDataDTO<ClassificationDTO>> getClassificationsByGender(@RequestParam(name="sexo", required = false) final String gender,
                                                                                     @RequestParam(name="faixa_etaria", required = false) final String ageRange){
        final ClassificationTypeEnum type = definitionTypeClassification.verifyType(gender, ageRange);
        final ListDataDTO<ClassificationDTO> classifications;
        switch (type){
            case GENDER -> classifications = new ListDataDTO<>(classificationService.getClassificationByGender((gender)));
            case AGE_RANGE -> classifications = new ListDataDTO<>(classificationService.getClassificationByAgeRange(ageRange));
            case GENDER_AND_AGE_RANGE -> classifications= new ListDataDTO<>(classificationService.getClassificationByGenderAndAgeRange(gender, ageRange));
            default -> classifications = new ListDataDTO<>(classificationService.getClassificationGeneral());
        }
        return ResponseEntity.ok(classifications);
    }
}
