package uk.ac.rhul.cs2800.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;

/**
 * Configures the Rest API.
 */
@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

  /**
   * Configure repository rest configuurations in Springboot.
   *
   * @param config The configuration object to customize the repository REST settings.
   * @param cors The registry object to configure Cross-Origin Resource Sharing (CORS) settings.
   */
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
      CorsRegistry cors) {
    config.exposeIdsFor(Student.class);
    config.exposeIdsFor(Module.class);
    config.exposeIdsFor(Grade.class);
  }
}