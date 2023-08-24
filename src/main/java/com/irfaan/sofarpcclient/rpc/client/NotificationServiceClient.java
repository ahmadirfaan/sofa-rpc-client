package com.irfaan.sofarpcclient.rpc.client;

import com.alipay.sofa.rpc.api.GenericService;
import com.alipay.sofa.rpc.config.ConsumerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class NotificationServiceClient {

    public void testingNotificationService() {
        ConsumerConfig<GenericService> consumerConfig = new ConsumerConfig<GenericService>()
                .setInterfaceId("com.irfaan.sofarpcserver.rpc.server.NotificationService")
                .setDirectUrl("0.0.0.0:12200")
                .setGeneric(true);
        GenericService genericService = consumerConfig.refer();

        var result = genericService.$invoke("result", new String[]{String.class.getName()}, new Object[]{"Irfaan Tampan"});
        var genericObject = (HashMap) result;
        var success = (Boolean) genericObject.get("success");
        var word = (String) genericObject.get("word");
        log.info(String.valueOf(success));
        log.info(word);
    }

}
