package com.shop.jpabooks.Domain.jpo;

import com.shop.jpabooks.Domain.model.MemberDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class MemberJpo {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", updatable = true)
    private String userName;

    // JPO to DTO
    public static MemberDto toDto(MemberJpo jpo) {
        return MemberDto
                .builder()
                .id(jpo.getId())
                .userName(jpo.getUserName())
                .build();
    }

}
