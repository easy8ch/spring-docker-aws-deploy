package com.goorm.tricountapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Settlement {
    private Long id;
    private String name;
    private List<Member> participants = Collections.emptyList();
}
