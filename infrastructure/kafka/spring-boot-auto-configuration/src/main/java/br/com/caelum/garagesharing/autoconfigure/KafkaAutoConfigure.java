package br.com.caelum.garagesharing.autoconfigure;

import br.com.caelum.garagesharing.infra.kafka.core.KafkaPublisherFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = KafkaPublisherFactory.class)
public class KafkaAutoConfigure {

}
