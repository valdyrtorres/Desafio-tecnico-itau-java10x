package dev.java10x.itauJava10x.estatistica;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(
    // NAO PODE SER 0 OU NUMERO NEGATIVO E TAMBEM NAO PODE SER VAZIO
    @NotNull
    @Positive
    Integer segundos
) {

}
