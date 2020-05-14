package ax.snuskriget.server.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-uri}")
    String introspectionUri;

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-id}")
    String clientId;

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-secret}")
    String clientSecret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    //.antMatchers(HttpMethod.GET, "//**").hasAuthority("SCOPE_message:read")
                    //.antMatchers(HttpMethod.GET, "/**").permitAll()
                    .anyRequest().permitAll() // Permit all until authentication is in place in front end
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
