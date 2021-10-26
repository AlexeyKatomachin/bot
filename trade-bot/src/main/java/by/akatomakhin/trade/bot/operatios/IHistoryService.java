package by.akatomakhin.trade.bot.operatios;

import by.akatomakhin.trade.bot.model.HistorySettings;
import by.akatomakhin.trade.bot.model.Order;

import java.util.List;

/**
 * Get data from market place storage
 */
public interface IHistoryService {

    /**
     * Get list orders from storage
     *
     * @return orders list
     */
    List<Order> getListOrder ();

    /**
     * Get completed list orders from storage
     *
     * @param settings request settings
     * @return orders list
     */
    List<Order> getCompletedOrders (HistorySettings settings);
}
