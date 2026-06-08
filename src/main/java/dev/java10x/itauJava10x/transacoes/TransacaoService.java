package dev.java10x.itauJava10x.transacoes;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoRequest transacaoRequest) {

        // VALOR MAIOROU IGUAL A 0
        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0) {
            // transacao não é válida valor menor ou igual a zero
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, transações devem ter valor maior do que zero");

        }

        // DATA MENOR OU IGUALA A DATA DE HOJE
        if(transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: Na data da transação");
        }

        if (validarDataPreenchida(transacaoRequest.getDataHora()) && validarHoraPreenchida(transacaoRequest.getDataHora())) {
            System.out.println("Data e hora foram preenchidas corretamente.");
        }

        // DATA PRESENTE (BODY NAO PODE SER VAZIO)
        if (!validarDataPreenchida(transacaoRequest.getDataHora())) {
            throw new IllegalArgumentException("Erro: Data não informada.");
        }

        // HORA PRESENTE (BODY NAO PODE SER VAZIO)
        if (!validarHoraPreenchida(transacaoRequest.getDataHora())) {
            throw new IllegalArgumentException("Erro: Hora não informada.");
        }
    }

    public static boolean validarDataPreenchida(OffsetDateTime dataHora) {
        if (dataHora == null) return false;
        // Se ano, mês e dia forem válidos, a data está preenchida
        return dataHora.getYear() > 0
                && dataHora.getMonthValue() > 0
                && dataHora.getDayOfMonth() > 0;
    }

    public static boolean validarHoraPreenchida(OffsetDateTime dataHora) {
        if (dataHora == null) return false;
        // Se hora, minuto e segundo forem válidos, a hora está preenchida
        return dataHora.getHour() >= 0
                && dataHora.getMinute() >= 0
                && dataHora.getSecond() >= 0;
    }
}
