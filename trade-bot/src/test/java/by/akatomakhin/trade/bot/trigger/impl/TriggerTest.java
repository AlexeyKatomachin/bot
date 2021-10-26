package by.akatomakhin.trade.bot.trigger.impl;

import by.akatomakhin.trade.bot.operatios.IHistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TriggerTest {
    @Autowired  private Trigger trigger;
    @MockBean   private IHistoryService historyService;


    @Test
    void orderEvent() {
        assertDoesNotThrow(() -> trigger.orderEvent(any()));

        verify(historyService).getListOrder();
        verify(historyService).getCompletedOrders(any());
        verifyNoMoreInteractions(historyService);
    }

    @Test
    void getCompletedOrders() {
    }

    @Test
    void getLevelsToUpdate() {
    }
}