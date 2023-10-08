package com.tapusd.demomongoref.domain;

import java.io.Serializable;
import java.time.Instant;

public abstract class AbstractDocument implements Serializable {
    private Status status;
    private boolean isDeleted;
    private Instant updatedAt;
    private Instant createdAt;
    private Instant deletedAt;

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
