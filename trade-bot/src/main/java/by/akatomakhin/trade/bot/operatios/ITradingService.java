package by.akatomakhin.trade.bot.operatios;

import by.akatomakhin.trade.bot.model.Order;

import java.util.List;

/**
 * Working with orders on trade platform
 */
public interface ITradingService {
    /**
     * Create order on trade platform
     *
     * @param order Order which should replace on trade platform
     */
    void pushOrder (Order order);

    /**
     * Create orders on trade platform
     *
     * @param orders Orders list which should replace on trade platform
     */
    void pushOrder (List<Order> orders);

    /**
     * Create trigger orders on trade platform
     *
     * @param orders Orders list which should replace on trade platform
     */
    void pushTriggerOrder (List<Order> orders);

    /**
     * Modify order in trade platform
     *
     * @param newOrder Order with modifications
     */
    void updateOrder (Order newOrder);

    /**
     * Remove order from trade platform
     *
     * @param order
     */
    void cancelOrder (Order order);
}
