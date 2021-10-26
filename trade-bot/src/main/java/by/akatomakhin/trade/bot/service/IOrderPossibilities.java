package by.akatomakhin.trade.bot.service;

import by.akatomakhin.trade.bot.model.Chance;
import by.akatomakhin.trade.bot.model.Order;
import javafx.scene.chart.Chart;

/**
 * Work with risks and possibilities
 */
public interface IOrderPossibilities {
    /**
     * Calculate order with possibilities of enter in market
     *
     * @param chart market info
     * @return order with possibilities of enter in market
     */
    Order calculateTradeVolume (Chart chart);

    /**
     * Calculate order with possibilities of take profit
     *
     * @param chart market info
     * @return order with possibilities of take profit
     */
    Order calculateTakeProfitOrder (Chart chart);

    /**
     * Get possibility next market step of market
     *
     * @param curr currency/type of market
     * @return Possibility
     */
    Chance getMarketChance(String curr);
}
