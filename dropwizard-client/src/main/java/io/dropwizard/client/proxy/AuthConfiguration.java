package io.dropwizard.client.proxy;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.validation.constraints.Pattern;

/**
 * Represents a configuration of credentials for either Username Password or NT credentials
 * <p/>
 * <b>Configuration Parameters:</b>
 * <table>
 *     <tr>
 *         <td>Name</td>
 *         <td>Default</td>
 *         <td>Description</td>
 *     </tr>
 *     <tr>
 *         <td>{@code username}</td>
 *         <td>REQUIRED</td>
 *         <td>The username used to connect to the server.</td>
 *     </tr>
 *     <tr>
 *         <td>{@code password}</td>
 *         <td>REQUIRED</td>
 *         <td>The password used to connect to the server.</td>
 *     </tr>
 *     <tr>
 *         <td>{@code authScheme}</td>
 *         <td>null</td>
 *         <td>Optional, The authentication scheme used by the underlying
 *         {@link org.apache.http.auth.AuthScope} class. Can be one of:<ul>
 *         <li>Basic</li><li>NTLM</li></ul></td>
 *     </tr>
 *     <tr>
 *         <td>{@code realm}</td>
 *         <td>null</td>
 *         <td>Optional, Realm to be used for NTLM Authentication.</td>
 *     </tr>
 *     <tr>
 *         <td>{@code hostname}</td>
 *         <td>null</td>
 *         <td>The hostname of the Principal in NTLM Authentication.</td>
 *     </tr>
 *     <tr>
 *         <td>{@code domain}</td>
 *         <td>null</td>
 *         <td>Optional, The domain used in NTLM Authentication.</td>
 *     </tr>
 *     <tr>
 *         <td>{@code credentialType}</td>
 *         <td>null</td>
 *         <td>The {@link org.apache.http.auth.Credentials} implementation
 *         to use for proxy authentication. Currently supports
 *         UsernamePassword ({@link org.apache.http.auth.UsernamePasswordCredentials}) and
 *         NT ({@link org.apache.http.auth.NTCredentials})</td>
 *     </tr>
 * </table>
 */
public class AuthConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthConfiguration.class);

    private static final String CTEST_GET_PARAM_FORMAT = "[CTEST][GET-PARAM] httpClient.proxy.auth.{}";
    private static final String CTEST_SET_PARAM_FORMAT = "[CTEST][SET-PARAM] httpClient.proxy.auth.{}";

    public static final String BASIC_AUTH_SCHEME = "Basic";

    public static final String NTLM_AUTH_SCHEME = "NTLM";

    public static final String USERNAME_PASSWORD_CREDS = "UsernamePassword";

    public static final String NT_CREDS = "NT";

    private String getStackTrace() {
        String stacktrace = " ";
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            stacktrace = stacktrace.concat(element.getClassName() + "\t");
        }
        return stacktrace;
    }

    @NotEmpty
    private String username = "";

    @NotEmpty
    private String password = "";

    @Pattern(regexp = BASIC_AUTH_SCHEME + "|" + NTLM_AUTH_SCHEME)
    @Nullable
    private String authScheme;

    @Nullable
    private String realm;

    @Nullable
    private String hostname;

    @Nullable
    private String domain;

    @Pattern(regexp = USERNAME_PASSWORD_CREDS + "|" + NT_CREDS, flags = {Pattern.Flag.CASE_INSENSITIVE})
    @Nullable
    private String credentialType;

    public AuthConfiguration() {
    }

    public AuthConfiguration(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthConfiguration(String username, String password, String authScheme, String realm, String hostname, String domain, String credentialType) {
        this.username = username;
        this.password = password;
        this.authScheme = authScheme;
        this.realm = realm;
        this.hostname = hostname;
        this.domain = domain;
        this.credentialType = credentialType;
    }

    @JsonProperty
    public String getUsername() {
        String ctestParam = "username";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return username;
    }

    @JsonProperty
    public void setUsername(String username) {
        String ctestParam = "username";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.username = username;
    }

    @JsonProperty
    public String getPassword() {
        String ctestParam = "password";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        String ctestParam = "password";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.password = password;
    }

    @JsonProperty
    @Nullable
    public String getAuthScheme() {
        String ctestParam = "authScheme";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return authScheme;
    }

    @JsonProperty
    public void setAuthScheme(String authScheme) {
        String ctestParam = "authScheme";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.authScheme = authScheme;
    }

    @JsonProperty
    @Nullable
    public String getRealm() {
        String ctestParam = "realm";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return realm;
    }

    @JsonProperty
    public void setRealm(String realm) {
        String ctestParam = "realm";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.realm = realm;
    }

    @JsonProperty
    @Nullable
    public String getHostname() {
        String ctestParam = "hostname";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return hostname;
    }

    @JsonProperty
    public void setHostname(String hostname) {
        String ctestParam = "hostname";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.hostname = hostname;
    }

    @JsonProperty
    @Nullable
    public String getDomain() {
        String ctestParam = "domain";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return domain;
    }

    @JsonProperty
    public void setDomain(String domain) {
        String ctestParam = "domain";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.domain = domain;
    }

    @JsonProperty
    @Nullable
    public String getCredentialType() {
        String ctestParam = "credentialType";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return credentialType;
    }

    @JsonProperty
    public void setCredentialType(String credentialType) {
        String ctestParam = "credentialType";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.credentialType = credentialType;
    }
}
