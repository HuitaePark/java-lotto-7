package lotto.domain;

import java.util.stream.Collectors;

public class LottoPrinter {

    public static String printLottoList(Lottos lottos) {
        return lottos.getLottos().stream()
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
