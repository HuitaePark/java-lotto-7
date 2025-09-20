package lotto.domain.winning;

public class Winner {

    private final Rank rank;

    public Winner(int count,boolean isSecond) {
        this.rank = Rank.of(count,isSecond);
    }

    public Rank getRank() {
        return rank;
    }
}
