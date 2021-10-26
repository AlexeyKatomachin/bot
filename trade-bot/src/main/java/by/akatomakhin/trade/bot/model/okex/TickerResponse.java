package by.akatomakhin.trade.bot.model.okex;

import java.util.List;

public class TickerResponse {
    private String code;
    private String msg;
    private List<TickerOkex> data;

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

    public List<TickerOkex> getData() {
        return data;
    }

    public void setData(List<TickerOkex> data) {
        this.data = data;
    }
}
