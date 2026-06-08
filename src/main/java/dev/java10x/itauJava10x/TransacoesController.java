package dev.java10x.itauJava10x;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
@Tag(name="Transações",
description = "Endpoints responsaveis por criar e adicionar as transacoes em uma lista assim como limpa-la")
public class TransacoesController {

    // injetar
    @Autowired // autowired está deprecated
    private TransacaoService transacaoService;
    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping
    @Operation(summary="Cria Transacao",
        description="Recebe uma transacao valida e adiciona em uma lista"
    )
    @ApiResponse(
            responseCode="201",
            description="Transacao criada com sucesso"
    )
    @ApiResponse(
            responseCode="422",
            description="Erro de validacao capturado"
    )
    @ApiResponse(
            responseCode="400",
            description="Erro inesperado no servidor"
    )
    public ResponseEntity adicionar(@RequestBody TransacaoRequest transacaoRequest) {
        log.info("Enviando requisicao de transacao para o servidor: ");

        try {
            transacaoService.validarTransacao(transacaoRequest);
            transacaoRepository.salvarDados(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(IllegalArgumentException exception) {
            log.error("Erro em uma ou mais validações, tente novamente");
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch(Exception e) {
            log.error("Erro no servidor, tente novamente");
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping
    public ResponseEntity deletar() {
        log.info("Lista de transacoes deletada: ");
        transacaoRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
