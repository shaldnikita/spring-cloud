package ru.shaldnikita.bookstore.domain;

import javax.annotation.Nonnull;
import javax.annotation.PreDestroy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * @author n.shaldenkov on 02.09.2018
 */
public class BaseEntityListener {


    @PrePersist
    public void setCreatedAndUpdatedDates(@Nonnull BaseEntity baseEntity) {
        baseEntity.setCreatedDate(LocalDateTime.now());
        baseEntity.setUpdatedDate(LocalDateTime.now());
        baseEntity.markAsNotNew();
    }

    @PreUpdate
    public void setUpdatedDate(@Nonnull BaseEntity baseEntity) {
        baseEntity.setUpdatedDate(LocalDateTime.now());
    }

    @PreDestroy
    public void setDeletedDate(@Nonnull BaseEntity baseEntity) {
        baseEntity.setDeletedDate(LocalDateTime.now());
    }

}
