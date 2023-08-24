package com.irfaan.sofarpcclient;

import com.irfaan.sofarpcclient.rpc.client.NotificationServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SofaRpcClientApplication implements CommandLineRunner {

    @Autowired
    private NotificationServiceClient serviceClient;

    public static void main(String[] args) {
        SpringApplication.run(SofaRpcClientApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        serviceClient.testingNotificationService();
    }
}
