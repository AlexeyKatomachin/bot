package by.akatomakhin.trade.bot.scheduler;

public abstract class AScheduler implements Runnable{
    protected abstract void runTask();
    @Override
    public void run() {
        runTask();
    }
}
