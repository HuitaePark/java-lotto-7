package lotto.domain;

import static lotto.global.constant.LottoConstant.LOTTO_COUNT_NUMBER;
import static lotto.global.constant.LottoConstant.LOTTO_END_NUMBER;
import static lotto.global.constant.LottoConstant.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.global.constant.LottoConstant.*;

public class LottoMachine {

    public Lottos collectLotto(int count){
        Lottos lottos = new Lottos();

        for(int i = 0;i<count;i++){
            lottos.addLottos(issuanceLotto());
        }

        return lottos;
    }

    private Lotto issuanceLotto(){
        return new Lotto(drawing());
    }

    private List<Integer> drawing(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER,LOTTO_END_NUMBER,LOTTO_COUNT_NUMBER);
    }

}
