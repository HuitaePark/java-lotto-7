package lotto.domain.purchase;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLotto() {
        return unmodifiableList(lottos);
    }

    public void addLotto(Lotto lotto){
        this.lottos.add(lotto);
    }
}
