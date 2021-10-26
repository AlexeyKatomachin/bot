package by.akatomakhin.trade.bot.service;

import by.akatomakhin.trade.bot.model.Order;
import by.akatomakhin.trade.bot.model.MarketGridSettings;
import by.akatomakhin.trade.bot.model.MarketGrid;

import java.util.List;

public interface IMarketView {
    /**
     * Create orders grid by settings.
     *
     * @param marketGridSettings orders grid settings
     * @return orders grid
     */
    MarketGrid createOrdersGrid (MarketGridSettings marketGridSettings);
    MarketGrid getOrdersGrid ();

    /**
     * Calculate order list on orders grid. Buy on lowest side of level and sell on highest side
     *
     * @param marketGrid orders grid
     * @return orders list
     */
//    List<Order> calculateOrdersList (MarketGrid marketGrid);

    /**
     * update order list based on orders grid
     *
     * @param marketGrid orders grid
     * @param orderList orders list
     */
//    void updateOrdersList (MarketGrid marketGrid, List<Order> orderList);
}
