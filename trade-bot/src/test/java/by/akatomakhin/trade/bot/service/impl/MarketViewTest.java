package by.akatomakhin.trade.bot.service.impl;

import by.akatomakhin.trade.bot.mapper.SettingsMapper;
import by.akatomakhin.trade.bot.operatios.IChartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

@SpringBootTest
class MarketViewTest {
    @Autowired  private MarketView marketView;
    @MockBean   private IChartService chartService;
    @MockBean   private SettingsMapper settingsMapper;

    @Test
    void createOrdersGrid() {
        assertDoesNotThrow(() -> marketView.createOrdersGrid(any()));

        verify(chartService).getCandles(any());
        verifyNoMoreInteractions(chartService);
        verify(settingsMapper).mapToGridSettingsMapper(any());
        verifyNoMoreInteractions(settingsMapper);
    }

    @Test
    void getOrdersGrid() {
        //TODO Throw exception
    }
}