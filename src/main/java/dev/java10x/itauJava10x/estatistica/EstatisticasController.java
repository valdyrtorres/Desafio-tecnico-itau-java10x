package dev.java10x.itauJava10x.estatistica;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    @GetMapping
    public ResponseEntity<String> estatistica60s() {
        return new ResponseEntity<>("{\n" +
                "\"count\":10,\n" +
                "\"sum\":1234.56,\n" +
                "\"avg\":123.456,\n" +
                "\"min\":12.34,\n" +
                "\"max\":123.56\n" +
                "}", HttpStatus.OK);
    }

}
