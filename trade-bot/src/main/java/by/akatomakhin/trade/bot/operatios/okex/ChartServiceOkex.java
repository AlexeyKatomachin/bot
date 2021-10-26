package by.akatomakhin.trade.bot.operatios.okex;

import by.akatomakhin.trade.bot.converter.JsonConverter;
import by.akatomakhin.trade.bot.mapper.MarketDataMapper;
import by.akatomakhin.trade.bot.model.Candle;
import by.akatomakhin.trade.bot.model.ChartSettings;
import by.akatomakhin.trade.bot.model.Ticker;
import by.akatomakhin.trade.bot.model.okex.CandleRequest;
import by.akatomakhin.trade.bot.model.okex.CandleResponse;
import by.akatomakhin.trade.bot.model.okex.TickerResponse;
import by.akatomakhin.trade.bot.operatios.IChartService;
import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.service.marketData.MarketDataAPIService;
import javafx.scene.chart.Chart;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChartServiceOkex implements IChartService {
    private final MarketDataAPIService marketDataAPIService;
    private final MarketDataMapper marketDataMapper;
    private final JsonConverter converter;

    public ChartServiceOkex(MarketDataAPIService marketDataAPIService, MarketDataMapper marketDataMapper, JsonConverter converter) {
        this.marketDataAPIService = marketDataAPIService;
        this.marketDataMapper = marketDataMapper;
        this.converter = converter;
    }

    @Override
    public List<Candle> getCandles(ChartSettings chartSettings) {
        CandleRequest candleRequest = marketDataMapper.mapperChartSettingsToCandleRequest(chartSettings);
        JSONObject candlesticks = marketDataAPIService.getCandlesticks(candleRequest.getInstId(), candleRequest.getAfter(),
                candleRequest.getBefore(), candleRequest.getBar(), candleRequest.getLimit());
        CandleResponse candleResponse = (CandleResponse) converter.convertFrom(candlesticks.toJSONString(), CandleResponse.class);
        return marketDataMapper.mapperCandleResponseToCandleList(candleResponse);
    }

    @Override
    public Ticker getTicker(ChartSettings chartSettings) {
        String instId = chartSettings.getCurr().toUpperCase() + "-USD-SPOT";
        JSONObject jsonTicker = marketDataAPIService.getTicker(instId);
        TickerResponse tickerResponse = (TickerResponse) converter.convertFrom(jsonTicker.toJSONString(), TickerResponse.class);
        return marketDataMapper.mapperTickerResponseToTicker(tickerResponse).get(0);
    }

    @Override
    public Chart getChart(ChartSettings chartSettings) {
        // TODO chart
        return null;
    }
}
