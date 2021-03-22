package com.cm.cm.online.product.entity.origin;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_ORIGIN_M")
@EqualsAndHashCode(of = "originCd")
public class OriginEntity {
    @Id
    private String originCd;
    private String originName;
}
