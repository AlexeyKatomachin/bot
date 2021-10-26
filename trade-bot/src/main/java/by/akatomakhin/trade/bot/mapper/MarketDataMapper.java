package by.akatomakhin.trade.bot.mapper;

import by.akatomakhin.trade.bot.model.Candle;
import by.akatomakhin.trade.bot.model.ChartSettings;
import by.akatomakhin.trade.bot.model.Ticker;
import by.akatomakhin.trade.bot.model.okex.CandleRequest;
import by.akatomakhin.trade.bot.model.okex.CandleResponse;
import by.akatomakhin.trade.bot.model.okex.TickerResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarketDataMapper {
    public CandleRequest mapperChartSettingsToCandleRequest(ChartSettings settings) {
        CandleRequest request = new CandleRequest();
        // TODO mapping
        return request;
    }

    public List<Candle> mapperCandleResponseToCandleList (CandleResponse response) {
        ArrayList<Candle> candles = new ArrayList<>();
        // TODO mapping
        return candles;
    }

    public List<Ticker> mapperTickerResponseToTicker (TickerResponse response){
        ArrayList<Ticker> tickers = new ArrayList<>();
        // TODO mapping
        return tickers;
    }
}
