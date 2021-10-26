package by.akatomakhin.trade.bot.strategy.impl;

import by.akatomakhin.trade.bot.util.model.MarketMap;
import by.akatomakhin.trade.bot.operatios.ITradingService;
import by.akatomakhin.trade.bot.repository.IOrderRepository;
import by.akatomakhin.trade.bot.service.IMarketView;
import by.akatomakhin.trade.bot.trigger.ITrigger;
import by.akatomakhin.trade.bot.util.IMarketMapUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

@SpringBootTest
class WallTradingTest {
    @Autowired      private WallTrading wallTrading;
    @MockBean       private IMarketView marketView;
    @MockBean       private IOrderRepository orderRepository;
    @MockBean       private ITrigger trigger;
    @MockBean       private IMarketMapUtil util;
    @MockBean       private ITradingService trading;

    @Test
    void initNeeded() {
        when(orderRepository.getMarketMap(any())).thenReturn(null);

        assertDoesNotThrow(() -> wallTrading.init());

        verify(util).calculateMarketMap(any(), any());
        verifyNoMoreInteractions(util);
        verify(orderRepository).getMarketMap(any());
        verify(orderRepository).getMarketGridSettings();
        verify(orderRepository).saveMarketMap(any());
        verifyNoMoreInteractions(orderRepository);
        verify(marketView).createOrdersGrid(any());
        verifyNoMoreInteractions(marketView);
        verifyNoInteractions(trigger);
        verifyNoInteractions(trading);
    }

    @Test
    void initNotNeeded() {
        when(orderRepository.getMarketMap(any())).thenReturn(new MarketMap());

        assertDoesNotThrow(() -> wallTrading.init());

        verifyNoInteractions(util);
        verify(orderRepository).getMarketMap(any());
        verify(orderRepository).getMarketGridSettings();
        verifyNoMoreInteractions(orderRepository);
        verifyNoInteractions(marketView);
        verifyNoInteractions(trigger);
        verifyNoInteractions(trading);
    }

    @Test
    void runStrategyNeeded() {
        when(trigger.orderEvent(any())).thenReturn(eq(true));

        assertDoesNotThrow(() -> wallTrading.runStrategy());

        verify(trigger).orderEvent(any());
        verify(trigger).getCompletedOrders();
        verifyNoMoreInteractions(trigger);
        verify(orderRepository).getMarketMap(any());
        verify(orderRepository).getMarketGridSettings();
        verify(orderRepository).updateMarketMap(any());
        verifyNoMoreInteractions(orderRepository);
        verify(util).syncMarketMap(any(), anyList());
        verify(util).getNewOrders(any(), any());
        verifyNoMoreInteractions(util);
        verify(marketView).createOrdersGrid(any());
        verifyNoMoreInteractions(marketView);
        verify(trading).pushTriggerOrder(anyList());
        verifyNoMoreInteractions(trading);
    }

    @Test
    void runStrategyNotNeeded() {
        when(trigger.orderEvent(any())).thenReturn(eq(false));

        assertDoesNotThrow(() -> wallTrading.runStrategy());

        verify(trigger).orderEvent(any());
        verifyNoMoreInteractions(trigger);
        verify(orderRepository).getMarketMap(any());
        verify(orderRepository).getMarketGridSettings();
        verifyNoMoreInteractions(orderRepository);
        verifyNoInteractions(util);
        verifyNoInteractions(marketView);
        verifyNoInteractions(trading);
    }
}