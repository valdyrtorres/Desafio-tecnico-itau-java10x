package dev.java10x.itauJava10x.estatistica;

import dev.java10x.itauJava10x.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @Autowired
    private TransacaoRepository transacaoRepository;

    // criar rota de estatistica e uma logica para trabalhar com os dados

    @GetMapping
    public ResponseEntity estatistica() {

        // Log de requisicao criado via lombok
        log.info("Calculando estatisticas de transações: ");

        // Calcular quantas transacoes acontecem em N segundos
        final var horaInicial = OffsetDateTime
                .now()
                .minusSeconds(estatisticaProperties.segundos());

        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }

}
