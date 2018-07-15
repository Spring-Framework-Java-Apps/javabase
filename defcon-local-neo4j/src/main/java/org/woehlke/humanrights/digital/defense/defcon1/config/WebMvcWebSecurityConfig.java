package org.woehlke.humanrights.digital.defense.defcon1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.session.security.web.authentication.SpringSessionRememberMeServices;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.woehlke.humanrights.digital.defense.defcon1.config.properties.ApplicationProperties;

//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * Created by tw on 24.06.18.
 *
 * TODO: #38
 */
@Configuration
@EnableWebMvc
@EnableWebSecurity
@EnableRedisHttpSession
//@EnableSpringDataWebSupport
@EnableConfigurationProperties({
    //AllProperties.class,
    //StorageProperties.class,
    ApplicationProperties.class
})
public class WebMvcWebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/welcome");
        registry.addViewController("/adm").setViewName("redirect:/adm/dashboard");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/*").addResourceLocations("classpath:/public/css/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/public/css/");
        registry.addResourceHandler("/icon/*").addResourceLocations("classpath:/public/icon/");
        registry.addResourceHandler("/icon/**").addResourceLocations("classpath:/public/icon/");
        registry.addResourceHandler("/img/*").addResourceLocations("classpath:/public/img/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/public/img/");
        registry.addResourceHandler("/js/*").addResourceLocations("classpath:/public/js/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/public/js/");
        registry.addResourceHandler("/map-icons/*").addResourceLocations("classpath:/public/map-icons/");
        registry.addResourceHandler("/map-icons/**").addResourceLocations("classpath:/public/map-icons/");
        registry.addResourceHandler("/webjars/*").addResourceLocations("/webjars/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Bean
    public SpringSessionBackedSessionRegistry sessionRegistry() {
        return new SpringSessionBackedSessionRegistry<>(this.sessionRepository);
    }


/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(
                applicationProperties.getWebSecurityConfigPublicPathsAsArray()
            )
            .permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage(applicationProperties.getLoginPage())
            .failureForwardUrl(applicationProperties.getFailureForwardUrl())
            .defaultSuccessUrl(applicationProperties.getDefaultSuccessUrl())
            .permitAll()
            .and()
            .rememberMe()
            .rememberMeServices(rememberMeServices())
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher(applicationProperties.getLogoutRequestMatcher()))
            .logoutSuccessUrl(applicationProperties.getLogoutSuccessUrl())
            .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String loginUsername = applicationProperties.getLoginUsername();
        String loginPassword = applicationProperties.getLoginPassword();
        String loginRole = applicationProperties.getLoginRole();
        auth
            .inMemoryAuthentication()
            .withUser(loginUsername)
            .password(loginPassword)
            .roles(loginRole);
    }
    */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(
                applicationProperties.getWebSecurityConfigPublicPathsAsArray()
            )
            .permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .failureForwardUrl("/login")
            .defaultSuccessUrl("/adm")
            .permitAll()
            .and()
            .rememberMe()
            .rememberMeServices(rememberMeServices())
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/logout_success")
            .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String user = "user" ; //applicationProperties.getLoginUsername();
        String pwd =  "password"; // applicationProperties.getLoginPassword();
        String role = "USER";
        auth
            .inMemoryAuthentication()
            .withUser(user).password(pwd).roles(role);
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        SpringSessionRememberMeServices rememberMeServices =
                new SpringSessionRememberMeServices();
        // optionally customize
        rememberMeServices.setAlwaysRemember(true);
        return rememberMeServices;
    }

    @Autowired
    private RedisOperationsSessionRepository sessionRepository;

    @Autowired
    private ApplicationProperties applicationProperties;

}
