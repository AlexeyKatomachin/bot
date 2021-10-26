package by.akatomakhin.trade.bot.model;

import java.util.Calendar;

public class MarketGridSettings {
    private String curr;
    private Calendar dateFrom;
    private Calendar dateTo;
    private String barSize;
    private int timeStep;

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public Calendar getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Calendar dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Calendar getDateTo() {
        return dateTo;
    }

    public void setDateTo(Calendar dateTo) {
        this.dateTo = dateTo;
    }

    public String getBarSize() {
        return barSize;
    }

    public void setBarSize(String barSize) {
        this.barSize = barSize;
    }

    public int getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }
}
