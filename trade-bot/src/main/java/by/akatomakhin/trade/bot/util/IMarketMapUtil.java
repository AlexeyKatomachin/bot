package by.akatomakhin.trade.bot.util;

import by.akatomakhin.trade.bot.util.model.MarketMap;
import by.akatomakhin.trade.bot.model.MarketMapSettings;
import by.akatomakhin.trade.bot.model.Order;
import by.akatomakhin.trade.bot.model.MarketGrid;

import java.util.List;

public interface IMarketMapUtil {
    MarketMapSettings calculateMarketMapSettings (MarketGrid marketGrid);
    MarketMap calculateMarketMap (MarketGrid marketGrid, MarketMapSettings settings);
    MarketMap syncMarketMap (MarketMap marketMap, List<Order> completedOrders);
    List<Order> getNewOrders (MarketMap oldMarketMap, MarketMap newMarketMap);
}
