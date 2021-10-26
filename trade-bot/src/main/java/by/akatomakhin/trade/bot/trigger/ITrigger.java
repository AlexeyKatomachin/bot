package by.akatomakhin.trade.bot.trigger;

import by.akatomakhin.trade.bot.util.model.MarketMap;
import by.akatomakhin.trade.bot.model.Order;

import java.util.List;

public interface ITrigger {
    boolean orderEvent (MarketMap marketMap);

    List<Order> getCompletedOrders ();

    List<MarketMap.Level> getLevelsToUpdate();
}
