package com.cm.cm.online.user.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_USER")
@EqualsAndHashCode(of = "userNum")
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long userNum;
    private String userName;
    private String userId;
    private String userPwd;
}
