package ru.shaldnikita.eurekaclient.domain;

import javax.annotation.Nonnull;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * @author n.shaldenkov on 02.09.2018
 */
public class BaseEntityListener {


    @PrePersist
    public void setCreatedAndUpdatedDates(@Nonnull BaseEntity baseEntity){
        baseEntity.setCreatedDate(LocalDateTime.now());
        baseEntity.setUpdatedDate(LocalDateTime.now());
    }

    @PreUpdate
    public void setUpdatedDate(@Nonnull BaseEntity baseEntity){
        baseEntity.setUpdatedDate(LocalDateTime.now());
    }
}
