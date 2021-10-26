package by.akatomakhin.trade.bot.strategy.model;

import java.math.BigDecimal;
import java.util.*;

public class ChangePercentGreed {
    private Map<Integer, ChangePercentPare> changePercentGreed;

    public ChangePercentGreed createStepPercentSeparate(BigDecimal maxCandleChangePercent, BigDecimal stepsCount, List<BigDecimal> candlesChangePercent) {
        for (int i = 0; i < stepsCount.intValue(); i++) {
            ChangePercentPare changePercentPare = new ChangePercentPare();
            changePercentPare.setPercentValue(maxCandleChangePercent.divide(maxCandleChangePercent, 2, BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(i)));
            this.getChangePercentGreed().put(i, changePercentPare);
        }
        candlesChangePercent.forEach(x -> {
            Map<Integer, ChangePercentPare> percentGreed = this.getChangePercentGreed();
            for (int i = 1; i < stepsCount.intValue(); i++) {
                BigDecimal highestLevelLimit = percentGreed.get(i).getPercentValue();
                BigDecimal lowerLevelLimit = percentGreed.get(i - 1).getPercentValue();
                if (highestLevelLimit.compareTo(x) <= 0 && lowerLevelLimit.compareTo(x) >= 0) {
                    BigDecimal changePointBetweenLevels = lowerLevelLimit
                            .add(highestLevelLimit.subtract(lowerLevelLimit).divide(new BigDecimal(2), 2, BigDecimal.ROUND_HALF_EVEN));
                    if (changePointBetweenLevels.compareTo(x) >= 0){
                        percentGreed.get(i).setCounter(percentGreed.get(i).getCounter().add(new BigDecimal(1)));
                    } else {
                        percentGreed.get(i - 1).setCounter(percentGreed.get(i - 1).getCounter().add(new BigDecimal(1)));
                    }
                }
            }
        });
        return this;
    }

    public BigDecimal getMostRepeatedPercent() {
        final BigDecimal maxCounting = changePercentGreed.values().stream()
                .map(ChangePercentPare::getCounter)
                .max(Comparator.naturalOrder())
                .orElse(new BigDecimal(0));
        return Objects.requireNonNull(changePercentGreed.values().stream()
                .filter(changePercentPare -> changePercentPare.getCounter().equals(maxCounting))
                .findFirst()
                .orElse(null)).getPercentValue();
    }

    public Map<Integer, ChangePercentPare> getChangePercentGreed() {
        if (this.changePercentGreed == null) {
            changePercentGreed = new HashMap<>();
        }
        return changePercentGreed;
    }

    public void setChangePercentGreed(Map<Integer, ChangePercentPare> changePercentGreed) {
        this.changePercentGreed = changePercentGreed;
    }
}
