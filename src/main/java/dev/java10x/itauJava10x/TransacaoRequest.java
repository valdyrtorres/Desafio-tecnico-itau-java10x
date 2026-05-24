package dev.java10x.itauJava10x;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequest {

    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
