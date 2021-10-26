package by.akatomakhin.trade.bot.model.okex;

import java.math.BigDecimal;
import java.util.List;

public class OrderResponse {
    private String code;
    private String msg;
    private List<OrderOkex> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<OrderOkex> getData() {
        return data;
    }

    public void setData(List<OrderOkex> data) {
        this.data = data;
    }
}
