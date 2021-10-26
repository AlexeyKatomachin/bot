package by.akatomakhin.trade.bot.model.okex;

import java.math.BigDecimal;
import java.util.List;

public class CandleResponse {
    private String code;
    private String msg;
    private List<List<BigDecimal>> data;

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

    public List<List<BigDecimal>> getData() {
        return data;
    }

    public void setData(List<List<BigDecimal>> data) {
        this.data = data;
    }
}
