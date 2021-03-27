package com.cm.cm.online.product.entity.origin;

import com.cm.cm.online.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 원산지 table(entity)
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "ORIGIN")
@EqualsAndHashCode(of = "cd")
public class OriginEntity extends BaseEntity {
    @Id
    private String cd;
    private String name;
}
