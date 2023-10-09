package com.tapusd.demomongoref.db.changelog;

import com.tapusd.demomongoref.domain.Country;
import com.tapusd.demomongoref.domain.Currency;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@ChangeUnit(id="currency-new-field-add-countryIds", order = "3", author = "tapusd")
public class CurrencyCountryFieldLoad {

    private final MongoTemplate mongoTemplate;

    public CurrencyCountryFieldLoad(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Execution
    public void changeSet() {
        Country unitedKingdom = mongoTemplate.findOne(new Query().addCriteria(Criteria.where("isoCode").is("GB")), Country.class);
        Country sweden = mongoTemplate.findOne(new Query().addCriteria(Criteria.where("isoCode").is("SW")), Country.class);
        Country norway = mongoTemplate.findOne(new Query().addCriteria(Criteria.where("isoCode").is("NO")), Country.class);

        mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("code").is("USD")),
                new Update().push("countryIds", unitedKingdom.getId()), Currency.class);

        mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("code").is("SK")),
                new Update().push("countryIds").each(new ObjectId[]{sweden.getId(), norway.getId()}), Currency.class);
    }

    @RollbackExecution
    public void rollbackChangeSet() {
        mongoTemplate.updateMulti(new Query(), new Update().unset("countryIds"), Currency.class);
    }
}
