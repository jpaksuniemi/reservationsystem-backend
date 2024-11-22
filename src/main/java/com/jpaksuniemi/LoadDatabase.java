package com.jpaksuniemi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private static final int TABLE_COUNT = 20;

    @Bean
    CommandLineRunner initReserveeTable(ReserverRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                log.info("Preloading " + repository.save(new Reserver("Jacob Jones", "jacob.jones@hitmail.com")));
            }
        };
    }

    @Bean
    CommandLineRunner initDiningTableTable(DiningTableRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Random r = new Random();
                List<DiningTable> diningTableList = new ArrayList<>(TABLE_COUNT);
                for (int i = 0; i < TABLE_COUNT; i++) {
                    diningTableList.add(new DiningTable(r.nextInt(5)+2));
                }
                diningTableList.forEach(diningTable -> {
                    log.info("Preloading " + repository.save(diningTable));
                });
            }
        };
    }
}
