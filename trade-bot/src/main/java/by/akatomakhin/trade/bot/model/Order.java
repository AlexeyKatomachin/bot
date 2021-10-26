package by.akatomakhin.trade.bot.model;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.math.BigDecimal;

public class Order {
    // Order ID
    private String id;
    // Instrument ID, e.g. BTC-USD-190927-5000-C
    private String instrumentId;
    // Trade mode. Margin mode cross isolated. Non-Margin mode cash
    private String tradeMode;
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
    private String quantity;
    // Order price. Only applicable to limit,post_only,fok,ioc order.
    private String price;
    private String triggerPx;
    private String orderPx;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(String tradeMode) {
        this.tradeMode = tradeMode;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTriggerPx() {
        return triggerPx;
    }

    public void setTriggerPx(String triggerPx) {
        this.triggerPx = triggerPx;
    }

    public String getOrderPx() {
        return orderPx;
    }

    public void setOrderPx(String orderPx) {
        this.orderPx = orderPx;
    }

    public Order createTriggerOrder (BigDecimal price, BigDecimal quantity, String mode, MarketGrid marketGrid) {
        this.instrumentId = marketGrid.getTicker().getInstrumentId();
        this.tradeMode = marketGrid.getTradeMode();
        this.side = mode;
        this.ordType = "trigger";
        this.quantity = quantity.toString();
        this.price = price.toString();
        this.orderPx = price.toString();
        this.triggerPx = price.toString();
        return this;
    }
}
