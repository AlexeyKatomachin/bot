package by.akatomakhin.trade.bot.service;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.config.APIConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.service.account.impl.AccountAPIServiceImpl;
import com.okex.open.api.websocket.*;

public class SimpleTrade {



    public static void main(String[] args) {
        APIConfiguration configuration = config();
        AccountAPIServiceImpl account = new AccountAPIServiceImpl(configuration);
        JSONObject balance = account.getBalance("USDT");

/*        WebSocketListener listener = new WebSocketAdapter() {
            @Override
            public void onTextMessage(WebSocket ws, String text) throws Exception {

            }

            @Override
            public void onWebsocketOpen(WebSocket ws) {

            }

            @Override
            public void handleCallbackError(WebSocket websocket, Throwable cause) {

            }

            @Override
            public void onWebsocketClose(WebSocket ws, int code) {

            }

            @Override
            public void onWebsocketPong(WebSocket ws) {

            }
        };
        WebSocketClient client = new WebSocketClient(listener);*/


    }

    public static APIConfiguration config() {
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
