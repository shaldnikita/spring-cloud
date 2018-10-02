package ru.shaldnikita.bookstore.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author n.shaldenkov on 02.09.2018
 */
@EntityListeners(BaseEntityListener.class)
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    private boolean isNew = true;

    @Getter
    private boolean deleted;

    @Getter
    @Setter
    private LocalDateTime createdDate;

    @Getter
    @Setter
    private LocalDateTime updatedDate;

    @Getter
    @Setter
    private LocalDateTime deletedDate;

    public void markAsNotNew() {
        this.isNew = false;
    }

    public void markAsDeleted() {
        this.deleted = true;
    }
}
