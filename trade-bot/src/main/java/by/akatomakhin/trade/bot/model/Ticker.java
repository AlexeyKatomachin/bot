package by.akatomakhin.trade.bot.model;

import java.math.BigDecimal;

public class Ticker {
    // Instrument type
    private String instrumentType;
    // Instrument ID
    private String instrumentId;
    // Last traded price
    private BigDecimal lastTradePrice;

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public BigDecimal getLastTradePrice() {
        return lastTradePrice;
    }

    public void setLastTradePrice(BigDecimal lastTradePrice) {
        this.lastTradePrice = lastTradePrice;
    }
}
