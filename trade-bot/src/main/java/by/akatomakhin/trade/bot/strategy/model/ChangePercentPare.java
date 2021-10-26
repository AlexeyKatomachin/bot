package by.akatomakhin.trade.bot.strategy.model;

import java.math.BigDecimal;

public class ChangePercentPare {
    private BigDecimal percentValue;
    private BigDecimal counter = new BigDecimal(0);

    public BigDecimal getPercentValue() {
        return percentValue;
    }

    public void setPercentValue(BigDecimal percentValue) {
        this.percentValue = percentValue;
    }

    public BigDecimal getCounter() {
        return counter;
    }

    public void setCounter(BigDecimal counter) {
        this.counter = counter;
    }
}
