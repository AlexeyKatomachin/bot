package by.akatomakhin.trade.bot.scheduler.impl;

import by.akatomakhin.trade.bot.scheduler.AScheduler;
import by.akatomakhin.trade.bot.strategy.IStrategy;
import by.akatomakhin.trade.bot.trigger.ITrigger;

public class WallTradingScheduler extends AScheduler {
    private IStrategy strategy;

    @Override
    protected void runTask() {
        strategy.runStrategy();
    }
}
