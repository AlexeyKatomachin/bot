package by.akatomakhin.trade.bot.operatios.okex;

import by.akatomakhin.trade.bot.converter.JsonConverter;
import by.akatomakhin.trade.bot.mapper.OrderMapper;
import by.akatomakhin.trade.bot.model.HistorySettings;
import by.akatomakhin.trade.bot.model.Order;
import by.akatomakhin.trade.bot.model.okex.OrderResponse;
import by.akatomakhin.trade.bot.operatios.IHistoryService;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.service.trade.TradeAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryServiceOkex implements IHistoryService {
    private final TradeAPIService tradeAPIService;
    private final JsonConverter converter;
    private final OrderMapper mapper;

    public HistoryServiceOkex(TradeAPIService tradeAPIService, JsonConverter converter, OrderMapper mapper) {
        this.tradeAPIService = tradeAPIService;
        this.converter = converter;
        this.mapper = mapper;
    }

    @Override
    public List<Order> getListOrder() {
        JSONObject orderList = tradeAPIService.getOrderList(null, null, null, null, null, null, null, null);
        OrderResponse orderResponse = (OrderResponse) converter.convertFrom(orderList.toJSONString(), OrderResponse.class);
        return mapper.convertOrderResponseToOrderList(orderResponse);
    }

    @Override
    public List<Order> getCompletedOrders(HistorySettings settings) {
        JSONObject response = tradeAPIService.getOrderHistory3months(settings.getInstType(), null, null, null, null, null, null, null);
        OrderResponse orderResponse = (OrderResponse) converter.convertFrom(response.toJSONString(), OrderResponse.class);
        return mapper.convertOrderResponseToOrderList(orderResponse);
    }
}
