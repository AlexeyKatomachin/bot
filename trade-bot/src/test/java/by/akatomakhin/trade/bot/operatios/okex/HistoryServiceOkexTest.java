package by.akatomakhin.trade.bot.operatios.okex;

import by.akatomakhin.trade.bot.converter.JsonConverter;
import by.akatomakhin.trade.bot.mapper.OrderMapper;
import com.okex.open.api.service.trade.TradeAPIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class HistoryServiceOkexTest {
    @Autowired  private HistoryServiceOkex historyServiceOkex;
    @MockBean   private TradeAPIService tradeAPIService;
    @MockBean   private JsonConverter converter;
    @MockBean   private OrderMapper mapper;

    @Test
    void getListOrder() {
        assertDoesNotThrow(() -> historyServiceOkex.getListOrder());

        verify(tradeAPIService).getOrderList(anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString());
        verifyNoMoreInteractions(tradeAPIService);
        verify(converter).convertFrom(anyString(), any());
        verifyNoMoreInteractions(converter);
        verify(mapper).convertOrderResponseToOrderList(any());
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void getCompletedOrders() {
        assertDoesNotThrow(() -> historyServiceOkex.getCompletedOrders(any()));

        verify(tradeAPIService).getOrderHistory3months(anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString());
        verifyNoMoreInteractions(tradeAPIService);
        verify(converter).convertFrom(anyString(), any());
        verifyNoMoreInteractions(converter);
        verify(mapper).convertOrderResponseToOrderList(any());
        verifyNoMoreInteractions(mapper);
    }
}