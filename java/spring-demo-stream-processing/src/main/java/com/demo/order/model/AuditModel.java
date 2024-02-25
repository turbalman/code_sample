package com.demo.order.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The type Audit model.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditModel implements Serializable {
    /**
     * The Created at.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    /**
     * The Updated at.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt;

    /**
     * Gets created at.
     *
     * @return the created at
     */
    Date getCreatedAt() {
        if (createdAt == null) {
            return null;
        } else {
            return new Date(createdAt.getTime());
        }
    }

    /**
     * Sets created at.
     *
     * @param date0 the date 0
     */
    void setCreatedAt(final Date date0) {
        if (date0 == null) {
            this.createdAt = null;
        } else {
            this.createdAt = new Date(date0.getTime());
        }
    }

    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    Date getUpdatedAt() {
        if (updatedAt == null) {
            return null;
        } else {
            return new Date(updatedAt.getTime());
        }
    }

    /**
     * Sets updated at.
     *
     * @param date0 the date 0
     */
    void setUpdatedAt(final Date date0) {
        if (date0 == null) {
            this.updatedAt = null;
        } else {
            this.updatedAt = new Date(date0.getTime());
        }
    }
}
