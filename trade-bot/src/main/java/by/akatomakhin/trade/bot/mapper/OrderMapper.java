package by.akatomakhin.trade.bot.mapper;

import by.akatomakhin.trade.bot.model.Order;
import by.akatomakhin.trade.bot.model.okex.OrderResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    public List<Order> convertOrderResponseToOrderList (OrderResponse response) {
        // TODO converting
        return new ArrayList<>();
    }
}
