package dev.java10x.itauJava10x.docs;

import dev.java10x.itauJava10x.transacoes.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="Transações",
        description = "Endpoints de criação de transações")
public interface TransacaoControllerDoc {

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
    ResponseEntity<Void> adicionar(@RequestBody TransacaoRequest transacaoRequest);

    @Operation(summary="Deleta Transacao",
            description="Remove todas as transacoes adicionadas a lista"
    )
    @ApiResponse(
            responseCode="200",
            description="Todas as transacoes foram deletadas"
    )
    ResponseEntity<Void> deletar();


}
