package com.shop.jpabooks.Domain.model;

import com.shop.jpabooks.Domain.jpo.MemberJpo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Member;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {

    private String id;
    private String userName;

    // DTO to JPO
    public static MemberJpo toJpo(MemberDto dto) {
        return MemberJpo
                .builder()
                .id(dto.getId())
                .userName(dto.getUserName())
                .build();
    }

}
