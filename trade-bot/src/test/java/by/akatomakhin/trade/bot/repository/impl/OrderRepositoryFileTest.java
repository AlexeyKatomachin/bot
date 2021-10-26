package by.akatomakhin.trade.bot.repository.impl;

import by.akatomakhin.trade.bot.converter.JsonConverter;
import by.akatomakhin.trade.bot.util.model.MarketMap;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrderRepositoryFileTest {
    @Autowired      private OrderRepositoryFile orderRepositoryFile;
    @MockBean       private JsonConverter converter;

    @Test
    void getMarketGridSettings() {
        assertDoesNotThrow(() -> orderRepositoryFile.getMarketGridSettings());

        verify(converter).readValue(anyString(), any(Class.class));
        verifyNoMoreInteractions(converter);
    }

    @Test
    void getMarketMap() {
        assertDoesNotThrow(() -> orderRepositoryFile.getMarketMap(anyString()));

        verify(converter).readValue(anyString(), new TypeReference<List<MarketMap>>() {});
        verifyNoMoreInteractions(converter);
    }

    @Test
    void updateMarketMap() {
        assertDoesNotThrow(() -> orderRepositoryFile.updateMarketMap(any()));
    }

    @Test
    void saveMarketMap() {
        assertDoesNotThrow(() -> orderRepositoryFile.saveMarketMap(any()));

        verify(converter).writeValue(anyString(), any());
        verifyNoMoreInteractions(converter);
    }
}