package eu.maryns.fix.source.instruments.config;


import eu.maryns.fix.source.instruments.model.Instrument;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import javax.annotation.PostConstruct;


@Configuration
@ComponentScan("eu.maryns.fix.source.instruments")
public class InstrumentConfiguration extends RepositoryRestConfigurerAdapter {

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Instrument.class);
    }

    @PostConstruct
    public void exposeIds() {
    }

}