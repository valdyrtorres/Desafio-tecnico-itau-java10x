package dev.java10x.itauJava10x.transacoes;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequest {

    @NotNull (message="O valor da transacao é obrigatório: ")
    @Positive (message="O valor da transacao deve ser igual ou maior a zero: ")
    private BigDecimal valor;
    private OffsetDateTime dataHora;

    public BigDecimal getValor() {
        return valor;
    }


    public OffsetDateTime getDataHora() {
        return dataHora;
    }

}
