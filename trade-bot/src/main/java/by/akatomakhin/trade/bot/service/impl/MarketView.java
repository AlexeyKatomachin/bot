package by.akatomakhin.trade.bot.service.impl;

import by.akatomakhin.trade.bot.mapper.SettingsMapper;
import by.akatomakhin.trade.bot.model.*;
import by.akatomakhin.trade.bot.operatios.IChartService;
import by.akatomakhin.trade.bot.service.IMarketView;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@Component
public class MarketView implements IMarketView {
    private static MarketGrid grid;
    private final IChartService chartService;
    private final SettingsMapper settingsMapper;

    public MarketView(IChartService chartService, SettingsMapper settingsMapper) {
        this.chartService = chartService;
        this.settingsMapper = settingsMapper;
    }

    @Override
    public MarketGrid createOrdersGrid(MarketGridSettings marketGridSettings) {
        grid = new MarketGrid();
        ChartSettings chartSettings = settingsMapper.mapToGridSettingsMapper(marketGridSettings);
        List<Candle> candles = chartService.getCandles(chartSettings);
        Ticker ticker = chartService.getTicker(chartSettings);
        grid.setCandles(candles);
        grid.setTicker(ticker);
        grid.setCurr(marketGridSettings.getCurr());
        grid.setTimeStep(marketGridSettings.getTimeStep());
        return grid;
    }

    @Override
    public MarketGrid getOrdersGrid() {
        assertNotNull("Grid wasn't created, use createOrdersGrid() before getOrdersGrid", grid);
        return grid;
    }
}
