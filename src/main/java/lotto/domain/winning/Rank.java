package lotto.domain.winning;

import java.util.Arrays;
import java.util.EnumMap;

public enum Rank {

    FIRST_PLACE(6, false, 2_000_000_000, "6개 일치 (%s원) - %d개"),
    SECOND_PLACE(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (%s원) - %d개"),
    THIRD_PLACE(5, false, 1_500_000, "5개 일치 (%s원) - %d개"),
    FOURTH_PLACE(4, false, 50_000, "4개 일치 (%s원) - %d개"),
    FIFTH_PLACE(3, false, 5_000, "3개 일치 (%s원) - %d개"),
    MISS(0, false, 0, "꽝");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final String messageFormat;

    Rank(int matchCount, boolean matchBonus, int prize, String messageFormat) {
        this.matchBonus = matchBonus;
        this.matchCount = matchCount;
        this.messageFormat = messageFormat;
        this.prize = prize;
    }

    public static Rank of(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == bonusMatch)
                .findFirst()
                .orElse(MISS);
    }

    public static EnumMap<Rank,Integer> initialize() {
        EnumMap<Rank,Integer> rankMap = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            rankMap.put(rank, 0); // 초기 디폴트값 0
        }

        return rankMap;
    }



    public String getMessage(int count) {
        return String.format(messageFormat, String.format("%,d", prize), count);
    }

    public int getPrize() {
        return prize;
    }
}
