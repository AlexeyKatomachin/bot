package by.akatomakhin.trade.bot.model;

import java.util.List;

public class MarketGrid {
    private String curr;
    private List<Candle> candles;
    private Ticker ticker;
    private int timeStep;
    private String tradeMode;

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public List<Candle> getCandles() {
        return candles;
    }

    public void setCandles(List<Candle> candles) {
        this.candles = candles;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public int getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    public String getTradeMode() {
        return "isolated";
    }

    public void setTradeMode(String tradeMode) {
        this.tradeMode = tradeMode;
    }
}
