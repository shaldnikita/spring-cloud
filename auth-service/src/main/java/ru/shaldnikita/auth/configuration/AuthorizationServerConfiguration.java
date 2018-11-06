package ru.shaldnikita.auth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import ru.shaldnikita.auth.service.security.SecurityUserDetailsService;

/**
 * @author n.shaldenkov on 18.08.2018
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private TokenStore tokenStore = new InMemoryTokenStore();

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityUserDetailsService userDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {


        // @formatter:off
        clients.inMemory()
                    .withClient("library")
                    .secret("changeme")
                    .scopes("ui")
                .authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token")
                    .autoApprove(true)
                .and()
                .withClient("costs-service")
                    .secret("changeme")
                    .scopes("server")
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                .and()
                .withClient("users-service")
                    .secret("changeme")
                    .scopes("server")
                    .authorizedGrantTypes("client_credentials", "refresh_token");
        // @formatter:on
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}