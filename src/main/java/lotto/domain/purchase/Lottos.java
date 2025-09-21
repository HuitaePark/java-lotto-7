package lotto.domain.purchase;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLotto() {
        return lottos;
    }

    public void addLotto(Lotto lotto){
        this.lottos.add(lotto);
    }
}
