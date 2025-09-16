package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    private final int ISSUANCE_START_NUMBER = 1;
    private final int ISSUANCE_END_NUMBER = 45;
    private final int ISSUANCE_COUNT_NUMBER = 6;

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
        return Randoms.pickUniqueNumbersInRange(ISSUANCE_START_NUMBER,ISSUANCE_END_NUMBER,ISSUANCE_COUNT_NUMBER);
    }

}
