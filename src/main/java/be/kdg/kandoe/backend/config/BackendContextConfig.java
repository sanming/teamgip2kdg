package be.kdg.kandoe.backend.config;

import org.h2.store.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main configuration file for the backend.
 * Configures backend services and repositories
 */

@Configuration
@ComponentScan(basePackages = "be.kdg.kandoe.backend",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)}
)
@EnableJpaRepositories(basePackages = "be.kdg.kandoe.backend.persistence")
@Import({DataSourceConfig.class,EntityTransactionManagerConfig.class})
public class BackendContextConfig
{
    // https://programmeren3-repaircafe.rhcloud.com/repair-cafe-applicatie/repair-cafe-backend/
}
