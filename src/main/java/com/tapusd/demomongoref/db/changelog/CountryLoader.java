package com.tapusd.demomongoref.db.changelog;

import com.tapusd.demomongoref.domain.Country;
import com.tapusd.demomongoref.domain.enums.Status;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.time.Instant;

@ChangeUnit(id="country-data-loader", order = "121023000", author = "tapusd")
public class CountryLoader {
    private final MongoTemplate mongoTemplate;

    public CountryLoader(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Execution
    public void changeSet() {
        mongoTemplate.save(new Country()
                .setName("United Kingdom")
                .setIsoCode("GB")
                .setIsoCodeFull("GBP")
                .setDialCode("83")
                .setStatus(Status.ENABLED)
                .setCreatedAt(Instant.now())
                .setIsDeleted(false)
        );

        mongoTemplate.save(new Country()
                .setName("Sweden")
                .setIsoCode("SW")
                .setIsoCodeFull("SWD")
                .setDialCode("33")
                .setStatus(Status.ENABLED)
                .setCreatedAt(Instant.now())
                .setIsDeleted(false)
        );

        mongoTemplate.save(new Country()
                .setName("Norway")
                .setIsoCode("NO")
                .setIsoCodeFull("NOR")
                .setDialCode("47")
                .setStatus(Status.ENABLED)
                .setCreatedAt(Instant.now())
                .setIsDeleted(false)
        );
    }

    @RollbackExecution
    public void rollbackChangeSet() {
        mongoTemplate.remove(new Query(), Country.class);
    }
}
