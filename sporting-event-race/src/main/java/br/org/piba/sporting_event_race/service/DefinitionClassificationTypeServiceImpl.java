package br.org.piba.sporting_event_race.service;

import br.org.piba.sporting_event_race.model.enumaration.ClassificationTypeEnum;

import java.util.Objects;

public class DefinitionClassificationTypeServiceImpl implements DefinitionClassificationTypeService {

    @Override
    public ClassificationTypeEnum verifyType(final String gender, final String ageRange){
        final boolean hasGender = isNotBlank(gender);
        final boolean hasAgeRanger = isNotBlank(ageRange);

        if(hasGender && hasAgeRanger){
            return ClassificationTypeEnum.GENDER_AND_AGE_RANGE;
        }

        if(!hasGender && !hasAgeRanger){
            return ClassificationTypeEnum.ALL;
        }

        return hasGender ? ClassificationTypeEnum.GENDER : ClassificationTypeEnum.AGE_RANGE;


    }

    private static boolean isNotBlank(final String string){
        return Objects.nonNull(string) && !string.isBlank() && !string.isEmpty();
    }
}
