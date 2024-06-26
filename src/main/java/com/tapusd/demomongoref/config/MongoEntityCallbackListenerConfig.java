package com.tapusd.demomongoref.config;

import com.tapusd.demomongoref.domain.Country;
import org.bson.Document;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import java.time.Instant;
import java.util.Objects;

/**
 * Enabled updatedAt with @LastModifiedAt mongo auditing framework
 * @deprecated this configuration is deprecated and NOT IN EFFECT
 */
//@Configuration
public class MongoEntityCallbackListenerConfig extends AbstractMongoEventListener<Country> {

    /**
     * Update the updatedAt property automatically through even callback
     * @param event
     */
    @Override
    public void onBeforeSave(BeforeSaveEvent<Country> event) {
        Document document = event.getDocument();
        if (Objects.nonNull(document) &&
            Objects.nonNull(document.getObjectId("_id"))) {
                document.put("updatedAt", Instant.now());
        }
        super.onBeforeSave(event);
    }
}
