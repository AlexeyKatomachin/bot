package by.akatomakhin.trade.bot.util.model;

import by.akatomakhin.trade.bot.model.MarketGrid;
import by.akatomakhin.trade.bot.model.MarketMapSettings;
import by.akatomakhin.trade.bot.model.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MarketMap {
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    private String curr;
    private String instType;
    private List<MarketMapLevel> levels;

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public List<MarketMapLevel> getLevels() {
        if (levels == null){
            levels = new ArrayList<>();
        }
        return levels;
    }

    public void setLevels(List<MarketMapLevel> levels) {
        this.levels = levels;
    }

    public List<MarketMapLevel> calculateMarketMapLevels(MarketMapSettings settings, MarketGrid marketGrid) {
        List<MarketMapLevel> levels = new ArrayList<>();
        int countLevelSteps = settings.getCountLevelSteps().intValue();
        for (int i = -countLevelSteps; i < countLevelSteps; i++) {
            levels.add(calculateMarketMapLevel(marketGrid, i, settings));
        }
        return levels;
    }

    public MarketMapLevel calculateMarketMapLevel (MarketGrid marketGrid, int stepLevel, MarketMapSettings settings) {
        MarketMapLevel level = new MarketMapLevel();
        BigDecimal lastTradePrice = marketGrid.getTicker().getLastTradePrice();
        BigDecimal sellPrice = lastTradePrice
                .add(lastTradePrice.multiply(settings.getStepPercentSeparate()).divide(ONE_HUNDRED, 2, BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(stepLevel)))
                .add(lastTradePrice.multiply(settings.getPercentCommission()).divide(ONE_HUNDRED, 2, BigDecimal.ROUND_HALF_EVEN));
        level.setSellInfo(new Order().createTriggerOrder(sellPrice, settings.getVolumeQuantity(), settings.getSellModeName(), marketGrid));

        BigDecimal buyPrice = lastTradePrice
                .add(lastTradePrice.multiply(settings.getStepPercentSeparate()).divide(ONE_HUNDRED, 2, BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(stepLevel - 1)))
                .subtract(lastTradePrice.multiply(settings.getPercentCommission()).divide(ONE_HUNDRED, 2, BigDecimal.ROUND_HALF_EVEN));
        level.setBuyInfo(new Order().createTriggerOrder(buyPrice, settings.getVolumeQuantity(), settings.getBuyModeName(), marketGrid));

        if (stepLevel > 0) {
            level.setCurrentMode(settings.getSellModeName());
        } else {
            level.setCurrentMode(settings.getBuyModeName());
        }

        return level;
    }
}
