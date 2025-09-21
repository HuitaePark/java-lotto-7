package lotto.presentation.adapter;

import java.util.stream.Collectors;
import lotto.domain.purchase.Lotto;
import lotto.domain.purchase.Lottos;

public class LottoPrinter {

    public static String printLottoList(Lottos lottos) {
        return lottos.getLotto().stream()
                .map(LottoPrinter::formatSingleLotto)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String formatSingleLotto(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
