package ru.shaldnikita.bookstore.domain;

import lombok.Data;

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
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
