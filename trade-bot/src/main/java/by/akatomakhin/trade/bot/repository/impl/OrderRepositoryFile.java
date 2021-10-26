package by.akatomakhin.trade.bot.repository.impl;

import by.akatomakhin.trade.bot.converter.JsonConverter;
import by.akatomakhin.trade.bot.model.MarketGridSettings;
import by.akatomakhin.trade.bot.util.model.MarketMap;
import by.akatomakhin.trade.bot.model.MarketMapSettings;
import by.akatomakhin.trade.bot.repository.IOrderRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRepositoryFile implements IOrderRepository {
    // TODO get value from properties
    private String marketGridSettingPath;
    // TODO get value from properties
    private String marketMapSettingPath;
    // TODO get value from properties
    private String marketMapPath;
    private JsonConverter converter;

    public OrderRepositoryFile(JsonConverter converter) {
        this.converter = converter;
    }

    @Override
    public MarketGridSettings getMarketGridSettings() {
        return (MarketGridSettings) converter.readValue(marketGridSettingPath, MarketGridSettings.class);
    }

    @Override
    public MarketMap getMarketMap(String curr) {
        List<MarketMap> marketMaps = converter.readValue(marketMapPath, new TypeReference<List<MarketMap>>() {});
        return marketMaps.stream().filter(x -> x.getCurr().equals(curr)).findFirst().orElse(null);
    }

    @Override
    public void updateMarketMap(MarketMap marketMap) {
        saveMarketMap(marketMap);
    }

    @Override
    public void saveMarketMap(MarketMap marketMap) {
        converter.writeValue(marketMapPath, MarketMap.class);
    }

    @Override
    public MarketMapSettings getMarketMapSettings() {
        return (MarketMapSettings) converter.readValue(marketGridSettingPath, MarketMapSettings.class);

    }
}
