package lotto.domain.common;

import static lotto.domain.common.LottoConstant.LOTTO_END_NUMBER;
import static lotto.domain.common.LottoConstant.LOTTO_START_NUMBER;

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
}
