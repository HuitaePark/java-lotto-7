package lotto.domain.purchase;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLottos(Lotto lotto){
        this.lottos.add(lotto);
    }
}
