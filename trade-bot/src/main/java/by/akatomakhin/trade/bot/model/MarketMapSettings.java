package by.akatomakhin.trade.bot.model;

import java.math.BigDecimal;

public class MarketMapSettings {
    private BigDecimal percentCommission;
    private BigDecimal stepPercentSeparate;
    private BigDecimal countLevelSteps;
    private BigDecimal volumeQuantity;
    private String sellModeName;
    private String buyModeName;

    public BigDecimal getPercentCommission() {
        return percentCommission;
    }

    public void setPercentCommission(BigDecimal percentCommission) {
        this.percentCommission = percentCommission;
    }

    public BigDecimal getStepPercentSeparate() {
        return stepPercentSeparate;
    }

    public void setStepPercentSeparate(BigDecimal stepPercentSeparate) {
        this.stepPercentSeparate = stepPercentSeparate;
    }

    public BigDecimal getCountLevelSteps() {
        return countLevelSteps;
    }

    public void setCountLevelSteps(BigDecimal countLevelSteps) {
        this.countLevelSteps = countLevelSteps;
    }

    public BigDecimal getVolumeQuantity() {
        return volumeQuantity;
    }

    public void setVolumeQuantity(BigDecimal volumeQuantity) {
        this.volumeQuantity = volumeQuantity;
    }

    public String getSellModeName() {
        return sellModeName;
    }

    public void setSellModeName(String sellModeName) {
        this.sellModeName = sellModeName;
    }

    public String getBuyModeName() {
        return buyModeName;
    }

    public void setBuyModeName(String buyModeName) {
        this.buyModeName = buyModeName;
    }
}
