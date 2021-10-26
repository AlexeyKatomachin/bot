package by.akatomakhin.trade.bot.operatios;

import by.akatomakhin.trade.bot.model.Candle;
import by.akatomakhin.trade.bot.model.ChartSettings;
import by.akatomakhin.trade.bot.model.Ticker;
import javafx.scene.chart.Chart;

import java.util.List;

/**
 * Market chart info
 */
public interface IChartService {
    /**
     * Get candles list about chart by settings
     *
     * @param chartSettings setting info
     * @return
     */
    List<Candle> getCandles (ChartSettings chartSettings);

    /**
     * Get current value(ticker)  
     *
     * @param chartSettings settings
     * @return ticker
     */
    Ticker getTicker (ChartSettings chartSettings);

    /**
     * Get chart info
     *
     * @param chartSettings settings info
     * @return chart info
     */
    Chart getChart (ChartSettings chartSettings);
}
