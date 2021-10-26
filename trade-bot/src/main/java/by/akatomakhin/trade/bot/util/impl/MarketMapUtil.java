package by.akatomakhin.trade.bot.util.impl;

import by.akatomakhin.trade.bot.model.MarketGrid;
import by.akatomakhin.trade.bot.util.model.MarketMap;
import by.akatomakhin.trade.bot.model.MarketMapSettings;
import by.akatomakhin.trade.bot.model.Order;
import by.akatomakhin.trade.bot.operatios.IChartService;
import by.akatomakhin.trade.bot.strategy.filter.IFilter;
import by.akatomakhin.trade.bot.strategy.model.ChangePercentGreed;
import by.akatomakhin.trade.bot.util.IMarketMapUtil;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class MarketMapUtil implements IMarketMapUtil {
    private List<IFilter> filters;
    private IChartService chartService;

    @Override
    public MarketMapSettings calculateMarketMapSettings(MarketGrid marketGrid) {
        return null;
    }

    @Override
    public MarketMap calculateMarketMap(MarketGrid marketGrid, MarketMapSettings settings) {
        MarketMap marketMap = new MarketMap();
        marketMap.setCurr(marketGrid.getCurr());
        List<BigDecimal> candlesChangePercent = marketGrid.getCandles().stream()
                .map(candle -> candle.getHighestPrice().subtract(candle.getLowestPrice()).multiply(new BigDecimal(100)).divide(candle.getOpenPrice(), 2, BigDecimal.ROUND_HALF_EVEN))
                .collect(Collectors.toList());
        BigDecimal maxCandleChangePercent = candlesChangePercent.stream().max(Comparator.naturalOrder()).orElse(new BigDecimal(0));
        ChangePercentGreed stepPercentSeparate = new ChangePercentGreed().createStepPercentSeparate(maxCandleChangePercent, new BigDecimal(10), candlesChangePercent);
        final BigDecimal mainPercent = stepPercentSeparate.getMostRepeatedPercent();
        settings.setStepPercentSeparate(mainPercent);
        marketMap.setLevels(marketMap.calculateMarketMapLevels(settings, marketGrid));
        return marketMap;
    }

    @Override
    public MarketMap syncMarketMap(MarketMap marketMap, List<Order> completedOrders) {
        return null;
    }

    @Override
    public List<Order> getNewOrders(MarketMap oldMarketMap, MarketMap newMarketMap) {
        return null;
    }


}
