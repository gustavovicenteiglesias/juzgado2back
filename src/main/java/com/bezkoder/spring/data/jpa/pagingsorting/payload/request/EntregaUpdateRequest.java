package com.bezkoder.spring.data.jpa.pagingsorting.payload;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntregaUpdateRequest {
    private List<Long> entregaIds;
    private String observacionesEntrega;
}

