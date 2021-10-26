package by.akatomakhin.trade.bot.repository;

import by.akatomakhin.trade.bot.util.model.MarketMap;
import by.akatomakhin.trade.bot.model.MarketGridSettings;
import by.akatomakhin.trade.bot.model.MarketMapSettings;

public interface IOrderRepository {
    MarketGridSettings getMarketGridSettings();

    /**
     * return buy/sell map for strategy
     * Should store in local kash and synchronize if needed
     *
     * @param curr currency
     * @return order buy/sell data
     */
    MarketMap getMarketMap (String curr);

    void updateMarketMap (MarketMap marketMap);

    void saveMarketMap (MarketMap marketMap);

    MarketMapSettings getMarketMapSettings();
}
