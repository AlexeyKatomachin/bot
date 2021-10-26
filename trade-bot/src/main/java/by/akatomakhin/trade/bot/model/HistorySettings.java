package by.akatomakhin.trade.bot.model;

public class HistorySettings {
    //Instrument type SPOT MARGIN SWAP FUTURES OPTION
    private String instType;

    public String getInstType() {
        return instType;
    }

    public HistorySettings setInstType(String instType) {
        this.instType = instType;
        return this;
    }
}
