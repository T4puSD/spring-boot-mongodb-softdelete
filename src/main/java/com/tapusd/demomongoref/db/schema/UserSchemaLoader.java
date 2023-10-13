package com.tapusd.demomongoref.db.schema;

import com.tapusd.demomongoref.domain.User;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

@ChangeUnit(id="user-schema-loader", order = "131023004", author = "tapusd")
public class UserSchemaLoader {

    private static final String EMAIL_PROPERTY_NAME = "email";

    private final MongoTemplate mongoTemplate;

    public UserSchemaLoader(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Execution
    public void changeSet() {
        mongoTemplate.indexOps(User.class)
                .ensureIndex(new Index().named(EMAIL_PROPERTY_NAME)
                        .on(EMAIL_PROPERTY_NAME, Sort.Direction.ASC).unique());
    }

    @RollbackExecution
    public void rollbackChangeSet() {
        mongoTemplate.indexOps(User.class)
                .dropIndex(EMAIL_PROPERTY_NAME);
    }
}
