package org.woehlke.humanrights.digital.defense.defcon1.config.properties;

/**
 * Created by tw on 24.06.18.
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Natural-Born-Coder
 */
@Component
@Validated
@ConfigurationProperties("org.woehlke.humanrights.digital.defense.defcon1.config")
public class ApplicationProperties {

    @NotNull
    private String loginUsername;

    @NotNull
    private String loginPassword;

    @NotNull
    private String loginPage;

    @NotNull
    private String failureForwardUrl;

    @NotNull
    private String defaultSuccessUrl;

    @NotNull
    private String logoutRequestMatcher;

    @NotNull
    private String logoutSuccessUrl;

    @NotNull
    private List<String> webSecurityConfigPublicPaths;

    @NotNull
    private String loginRole;

    public String[] getWebSecurityConfigPublicPathsAsArray() {
        int size = webSecurityConfigPublicPaths.size();
        String[] myArray = new String[size];
        for(int i=0; i<size; i++){
            myArray[i] = webSecurityConfigPublicPaths.get(i);
        }
        return myArray;
    }

    public String getLoginRole() {
        return loginRole;
    }

    public void setLoginRole(String loginRole) {
        this.loginRole = loginRole;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getFailureForwardUrl() {
        return failureForwardUrl;
    }

    public void setFailureForwardUrl(String failureForwardUrl) {
        this.failureForwardUrl = failureForwardUrl;
    }

    public String getDefaultSuccessUrl() {
        return defaultSuccessUrl;
    }

    public void setDefaultSuccessUrl(String defaultSuccessUrl) {
        this.defaultSuccessUrl = defaultSuccessUrl;
    }

    public String getLogoutRequestMatcher() {
        return logoutRequestMatcher;
    }

    public void setLogoutRequestMatcher(String logoutRequestMatcher) {
        this.logoutRequestMatcher = logoutRequestMatcher;
    }

    public String getLogoutSuccessUrl() {
        return logoutSuccessUrl;
    }

    public void setLogoutSuccessUrl(String logoutSuccessUrl) {
        this.logoutSuccessUrl = logoutSuccessUrl;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public List<String> getWebSecurityConfigPublicPaths() {
        return webSecurityConfigPublicPaths;
    }

    public void setWebSecurityConfigPublicPaths(List<String> webSecurityConfigPublicPaths) {
        this.webSecurityConfigPublicPaths = webSecurityConfigPublicPaths;
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "loginUsername='" + loginUsername + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", loginPage='" + loginPage + '\'' +
                ", failureForwardUrl='" + failureForwardUrl + '\'' +
                ", defaultSuccessUrl='" + defaultSuccessUrl + '\'' +
                ", logoutRequestMatcher='" + logoutRequestMatcher + '\'' +
                ", logoutSuccessUrl='" + logoutSuccessUrl + '\'' +
                ", webSecurityConfigPublicPaths=" + webSecurityConfigPublicPaths +
                ", loginRole='" + loginRole + '\'' +
                '}';
    }

    public void logDebug(){
        LOGGER.debug("vla: "+toString());
    }


    private static final Log LOGGER = LogFactory.getLog(ApplicationProperties.class);
}
