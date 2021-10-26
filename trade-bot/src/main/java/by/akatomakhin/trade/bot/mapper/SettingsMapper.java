package by.akatomakhin.trade.bot.mapper;

import by.akatomakhin.trade.bot.model.ChartSettings;
import by.akatomakhin.trade.bot.model.MarketGridSettings;
import org.springframework.stereotype.Component;

@Component
public class SettingsMapper {
    public ChartSettings mapToGridSettingsMapper (MarketGridSettings marketGridSettings) {
        return new ChartSettings();
    }
}
