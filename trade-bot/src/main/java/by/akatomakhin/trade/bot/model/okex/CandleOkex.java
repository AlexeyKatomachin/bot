package by.akatomakhin.trade.bot.model.okex;

import by.akatomakhin.trade.bot.model.Candle;

public class CandleOkex {
    private String ts;
    private String o;
    private String h;
    private String l;
    private String c;
    private String vol;
    private String volCcy;

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getVolCcy() {
        return volCcy;
    }

    public void setVolCcy(String volCcy) {
        this.volCcy = volCcy;
    }

    public Candle getCandle() {
        Candle candle = new Candle();
        return candle;
    }
}
