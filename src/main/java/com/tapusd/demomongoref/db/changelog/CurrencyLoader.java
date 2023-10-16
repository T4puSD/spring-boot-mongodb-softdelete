package com.tapusd.demomongoref.db.changelog;

import com.tapusd.demomongoref.domain.Currency;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@ChangeUnit(id="currency-data-loader", order = "121023002", author = "tapusd")
public class CurrencyLoader {

    private final MongoTemplate mongoTemplate;

    public CurrencyLoader(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Execution
    public void changeSet() {
        List<Currency> currencies = List.of(
                new Currency()
                        .setName("Bangladeshi Taka")
                        .setCode("BDT"),
                new Currency()
                        .setName("United State Doller")
                        .setCode("USD"),
                new Currency()
                        .setName("Swedish Krona")
                        .setCode("SK")

        );

        currencies.forEach(mongoTemplate::save);
    }

    @RollbackExecution
    public void rollbackChangeSet() {
        mongoTemplate.remove(new Query(), Currency.class);
    }
}
