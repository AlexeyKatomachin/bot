package by.akatomakhin.trade.bot.strategy.impl;

import by.akatomakhin.trade.bot.util.model.MarketMap;
import by.akatomakhin.trade.bot.model.MarketMapSettings;
import by.akatomakhin.trade.bot.model.Order;
import by.akatomakhin.trade.bot.model.MarketGridSettings;
import by.akatomakhin.trade.bot.operatios.ITradingService;
import by.akatomakhin.trade.bot.repository.IOrderRepository;
import by.akatomakhin.trade.bot.service.IMarketView;
import by.akatomakhin.trade.bot.strategy.IStrategy;
import by.akatomakhin.trade.bot.trigger.ITrigger;
import by.akatomakhin.trade.bot.util.IMarketMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Wall Trading mean creating orders grid and trade in levels. Buy on lowest side of level and sell on highest side
 */
@Component
public class WallTrading implements IStrategy {
    private final IMarketView marketView;
    private final IOrderRepository orderRepository;
    private final ITrigger trigger;
    private final IMarketMapUtil util;
    private final ITradingService trading;

    @Autowired
    public WallTrading(IMarketView marketView, IOrderRepository orderRepository, ITrigger trigger,
                       IMarketMapUtil util, ITradingService trading) {
        this.marketView = marketView;
        this.orderRepository = orderRepository;
        this.trigger = trigger;
        this.util = util;
        this.trading = trading;
    }

    @Override
    public void init() {
        MarketGridSettings marketGridSettings = orderRepository.getMarketGridSettings();
        MarketMapSettings marketMapSettings = orderRepository.getMarketMapSettings();
        if (orderRepository.getMarketMap(marketGridSettings.getCurr()) == null){
            orderRepository.saveMarketMap(util.calculateMarketMap(marketView.createOrdersGrid(marketGridSettings), marketMapSettings));
        }
    }

    @Override
    public void runStrategy() {
        MarketGridSettings marketGridSettings = orderRepository.getMarketGridSettings();
        MarketMap marketMap = orderRepository.getMarketMap(marketGridSettings.getCurr());
        if (trigger.orderEvent(marketMap)) {
            List<Order> completedOrders = trigger.getCompletedOrders();
            MarketMap syncMarketMap = util.syncMarketMap(marketMap, completedOrders);
            List<Order> newOrders = util.getNewOrders(marketMap, syncMarketMap);
            trading.pushTriggerOrder(newOrders);
            orderRepository.updateMarketMap(syncMarketMap);
        }
    }
}
