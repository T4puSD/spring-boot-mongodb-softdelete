package com.tapusd.demomongoref.domain;

import com.tapusd.demomongoref.domain.enums.Status;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.Instant;

public abstract class AbstractDocument implements Serializable {

    @Id
    private String id;
    private Status status = Status.ENABLED;
    private boolean isDeleted;
    private Instant updatedAt;
    private Instant createdAt = Instant.now();
    private Instant deletedAt;

    public String getId() {
        return id;
    }

    public AbstractDocument setId(String id) {
        this.id = id;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public AbstractDocument setStatus(Status status) {
        this.status = status;
        return this;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public AbstractDocument setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public AbstractDocument setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public AbstractDocument setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public AbstractDocument setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }
}
