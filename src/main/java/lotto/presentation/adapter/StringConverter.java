package lotto.presentation.adapter;

public class StringConverter {
    public static final String COMMA = ",";
    private static final String INVALID_INPUT_FORMAT = "콤마로 구분을 해야 합니다.";

    public static String[] convertStringArray(String input){
        validateInputDelimiter(input);
        return input.split(COMMA);
    }

    private static void validateInputDelimiter(String input){
        if(!input.contains(COMMA)){
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }
}
