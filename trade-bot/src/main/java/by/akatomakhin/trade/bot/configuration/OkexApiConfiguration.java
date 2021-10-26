package by.akatomakhin.trade.bot.configuration;

import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.service.marketData.MarketDataAPIService;
import com.okex.open.api.service.marketData.impl.MarketDataAPIServiceImpl;
import com.okex.open.api.service.trade.TradeAPIService;
import com.okex.open.api.service.trade.impl.TradeAPIServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkexApiConfiguration {

    @Bean
    public TradeAPIService getTradeApi() {
        return new TradeAPIServiceImpl(getApiConfiguration());
    }

    @Bean
    public MarketDataAPIService getMarketDataAPI() {
        return new MarketDataAPIServiceImpl(getApiConfiguration());
    }

    @Bean
    public APIConfiguration getApiConfiguration() {
        APIConfiguration config = new APIConfiguration();
        config.setEndpoint("https://www.okex.com/");
        // apiKey，api注册成功后页面上有


        config.setApiKey("0ce67684-d894-4105-bc36-e22527088736");
        config.setSecretKey("269E20554B55A5ADEC863B4A5C4E9CC2");
        config.setPassphrase("Garret1996");


        config.setPrint(true);
        config.setI18n(I18nEnum.ENGLISH);
        return config;
    }
}
