package ax.snuskriget.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebSecurity
public class SnuskrigetApplication extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-uri}")
    String introspectionUri;

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-id}")
    String clientId;

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-secret}")
    String clientSecret;

    public static void main(final String[] args) {
        SpringApplication.run(SnuskrigetApplication.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .cors().and() //TODO add configuration to allow explicit origins
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    //.antMatchers(HttpMethod.GET, "//**").hasAuthority("SCOPE_message:read")
                    //.antMatchers(HttpMethod.GET, "/**").permitAll()
                    .anyRequest().authenticated() // Permit all until authentication is in place in front end
            )
            .oauth2ResourceServer(oauth2ResourceServer ->
                oauth2ResourceServer
                    .opaqueToken(opaqueToken ->
                        opaqueToken
                            .introspectionUri(this.introspectionUri)
                            .introspectionClientCredentials(this.clientId, this.clientSecret)
                    )
            );
        // @formatter:on
    }
}
