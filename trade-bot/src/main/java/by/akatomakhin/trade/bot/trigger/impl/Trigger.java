package by.akatomakhin.trade.bot.trigger.impl;

import by.akatomakhin.trade.bot.model.HistorySettings;
import by.akatomakhin.trade.bot.util.model.MarketMap;
import by.akatomakhin.trade.bot.model.Order;
import by.akatomakhin.trade.bot.operatios.IHistoryService;
import by.akatomakhin.trade.bot.trigger.ITrigger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Trigger implements ITrigger {
    private List<MarketMap.Level> levelsToUpdate;
    private IHistoryService historyService;

    public Trigger(IHistoryService historyService) {
        this.historyService = historyService;
    }

    @Override
    public boolean orderEvent(MarketMap marketMap) {
        final Set<Integer> ordersIdSet = historyService.getListOrder().stream()
                .mapToInt(x -> Integer.getInteger(x.getId()))
                .boxed()
                .collect(Collectors.toSet());
        final Set<Integer> completedOrdersIdSet = historyService.getCompletedOrders(new HistorySettings().setInstType(marketMap.getInstType())).stream()
                .mapToInt(x -> Integer.getInteger(x.getId()))
                .boxed()
                .collect(Collectors.toSet());
        List<MarketMap.Level> levelsToUpdate = marketMap.getLevels().stream()
                .filter(level -> !ordersIdSet.contains(Integer.getInteger(level.getOrder().getId()))
                        && completedOrdersIdSet.contains(Integer.getInteger(level.getOrder().getId())))
                .collect(Collectors.toList());
        this.levelsToUpdate = levelsToUpdate;
        return !levelsToUpdate.isEmpty();
    }

    @Override
    public List<Order> getCompletedOrders() {
        return levelsToUpdate.stream().map(MarketMap.Level::getOrder).collect(Collectors.toList());
    }

    @Override
    public List<MarketMap.Level> getLevelsToUpdate() {
        return levelsToUpdate;
    }
}
