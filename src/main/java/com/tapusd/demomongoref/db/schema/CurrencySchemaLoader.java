package com.tapusd.demomongoref.db.schema;

import com.tapusd.demomongoref.domain.Currency;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

@ChangeUnit(id="currency-schema-loader", order = "0131023001", author = "tapusd")
public class CurrencySchemaLoader {

    private static final String INDEX_PROPERTY_NAME = "code";

    private final MongoTemplate mongoTemplate;

    public CurrencySchemaLoader(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Execution
    public void changeSet() {
        // unique currency code index
        mongoTemplate.indexOps(Currency.class)
                .ensureIndex(new Index().named(INDEX_PROPERTY_NAME)
                        .on(INDEX_PROPERTY_NAME, Sort.Direction.ASC).unique());
    }

    @RollbackExecution
    public void rollbackChangeSet() {
        mongoTemplate.indexOps(Currency.class)
                .dropIndex(INDEX_PROPERTY_NAME);
    }
}
