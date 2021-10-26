package by.akatomakhin.trade.bot.util.model;

import by.akatomakhin.trade.bot.model.Order;

public class MarketMapLevel {
    private String currentMode;
    private Order order;
    private Order buyInfo;
    private Order sellInfo;

    public String getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(String currentMode) {
        this.currentMode = currentMode;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getBuyInfo() {
        return buyInfo;
    }

    public void setBuyInfo(Order buyInfo) {
        this.buyInfo = buyInfo;
    }

    public Order getSellInfo() {
        return sellInfo;
    }

    public void setSellInfo(Order sellInfo) {
        this.sellInfo = sellInfo;
    }
}
