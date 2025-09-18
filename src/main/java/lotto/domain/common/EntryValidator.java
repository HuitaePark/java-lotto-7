package lotto.domain.common;

import static lotto.domain.common.LottoConstant.LOTTO_COUNT_NUMBER;
import static lotto.domain.common.LottoConstant.LOTTO_END_NUMBER;
import static lotto.domain.common.LottoConstant.LOTTO_START_NUMBER;
import static lotto.domain.common.error.ErrorCode.INVALID_LOTTO_SIZE;

import java.util.Arrays;
import lotto.domain.common.error.ErrorCode;
import lotto.domain.common.error.exception.LottoIllegalArgumentException;

public class EntryValidator {

    private EntryValidator() {
    }

    public static void validate(String entry){
        validateEmpty(entry);
        validateNumber(entry);
        validateLottoRange(entry);
    }

    public static void validate(String[] numberArr){
        validateLottoDistinct(numberArr);
        validateEntrySize(numberArr);
    }

    private static void validateLottoRange(String i){
        if(!isInLottoRange(Integer.parseInt(i))){
            throw new LottoIllegalArgumentException(ErrorCode. INVALID_LOTTO_RANGE);
        }
    }

    private static boolean isInLottoRange(int i){
        return i >= LOTTO_START_NUMBER && i<= LOTTO_END_NUMBER;
    }

    private static void validateNumber(String entry){
        if(!entry.matches("\\d+")){
            throw new LottoIllegalArgumentException(ErrorCode. INVALID_STRING);
        }
    }

    private static void validateEmpty(String entry){
        if(entry.isEmpty()){
            throw new LottoIllegalArgumentException(ErrorCode. INVALID_EMPTY);
        }
    }

    private static void validateLottoDistinct(String[] numberArr){
        String[] mapArr = distinctArr(numberArr);
        if(mapArr.length!=LOTTO_COUNT_NUMBER){
            throw new LottoIllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    private static void validateEntrySize(String[] numberArr) {
        if(numberArr.length!=LOTTO_COUNT_NUMBER){
            throw new LottoIllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    private static String[] distinctArr(String[] strArr){
        return Arrays.stream(strArr).distinct().toArray(String[]::new);
    }
}
