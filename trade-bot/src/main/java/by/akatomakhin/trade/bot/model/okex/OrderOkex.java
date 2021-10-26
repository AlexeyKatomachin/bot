package by.akatomakhin.trade.bot.model.okex;

import by.akatomakhin.trade.bot.model.Order;

public class OrderOkex {
    // Order ID
    private String ordId;
    // Instrument ID, e.g. BTC-USD-190927-5000-C
    private String instId;
    // Trade mode. Margin mode cross isolated. Non-Margin mode cash
    private String tdMode;
    // Margin currency. Only applicable to cross MARGIN orders in Single-currency margin.
    private String ccy;
    // Client-supplied order ID. A combination of case-sensitive alphanumerics, all numbers, or all letters of up to 32 characters
    private String clOrdId;
    // Order tag. A combination of case-sensitive alphanumerics, all numbers, or all letters of up to 8 characters.
    private String tag;
    // Order side, buy sell
    private String side;
    //Position side. The default is net in the net mode. It is required in the long/short mode, and can only be long or short.Only applicable to FUTURES/SWAP.
    private String posSide;
    //Order type
    //market: market order
    //limit: limit order
    //post_only: Post-only order
    //fok: Fill-or-kill order
    //ioc: Immediate-or-cancel order
    //optimal_limit_ioc :Market order with immediate-or-cancel order (applicable only to Futures and Perpetual swap).
    private String ordType;
    // Quantity to buy or sell
    private String sz;
    // Order price. Only applicable to limit,post_only,fok,ioc order.
    private String px;
    //Whether to reduce position only or not, true false, the default is false.
    //Only applicable to MARGIN orders
    private Boolean reduceOnly;
    //Quantity type
    //base_ccy：Base currency ；quote_ccy：Quote currency
    //Only applicable to SPOT traded with Market order
    private String tgtCcy;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getTdMode() {
        return tdMode;
    }

    public void setTdMode(String tdMode) {
        this.tdMode = tdMode;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getClOrdId() {
        return clOrdId;
    }

    public void setClOrdId(String clOrdId) {
        this.clOrdId = clOrdId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getPosSide() {
        return posSide;
    }

    public void setPosSide(String posSide) {
        this.posSide = posSide;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public String getSz() {
        return sz;
    }

    public void setSz(String sz) {
        this.sz = sz;
    }

    public String getPx() {
        return px;
    }

    public void setPx(String px) {
        this.px = px;
    }

    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(Boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public String getTgtCcy() {
        return tgtCcy;
    }

    public void setTgtCcy(String tgtCcy) {
        this.tgtCcy = tgtCcy;
    }

    public Order convertToOrder (){
        Order order = new Order();
        return order;
    }
}
