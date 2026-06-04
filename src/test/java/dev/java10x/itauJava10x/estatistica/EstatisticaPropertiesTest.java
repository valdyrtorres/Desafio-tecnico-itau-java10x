package dev.java10x.itauJava10x.estatistica;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EstatisticaPropertiesTest {

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @Test
    void deveCarregarValorDeSegundosDoYaml() {
        assertThat(estatisticaProperties.segundos()).isEqualTo(60);
    }
}
