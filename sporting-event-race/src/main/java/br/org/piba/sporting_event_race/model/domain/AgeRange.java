package br.org.piba.sporting_event_race.model.domain;

public record AgeRange(int initialAge, int limitAge) {

    public enum RangeAgeDefinition {
        SIX_TO_SEVEN("6 - 7"),
        EIGHT_TO_TWELVE("8 - 12"),
        THIRTEEN_TO_FIFTEEN("13 - 15"),
        SIXTEEN_TO_TWENTY("16 - 20"),
        TWENTY_ONE_TO_THIRTY("21 - 30"),
        THIRTY_ONE_TO_FOURTH("31 - 40"),
        FOURTH_ONE_TO_FIFTH("41 - 50"),
        FIFTH_ONE_TO_SIXTH("51 - 60"),
        SIXTH_ONE_OR_MORE("61+");

        private final String value;

        RangeAgeDefinition(final String range){
            value = range;
        }
        public String value(){
            return  value;
        }
    }

}
