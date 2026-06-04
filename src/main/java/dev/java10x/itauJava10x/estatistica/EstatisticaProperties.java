package dev.java10x.itauJava10x.estatistica;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(Integer segundos) {

}
