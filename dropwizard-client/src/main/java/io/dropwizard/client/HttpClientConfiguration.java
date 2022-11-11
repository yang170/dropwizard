package io.dropwizard.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.client.proxy.ProxyConfiguration;
import io.dropwizard.client.ssl.TlsConfiguration;
import io.dropwizard.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * The configuration class used by {@link HttpClientBuilder}.
 *
 * @see <a href="http://dropwizard.io/0.9.1/docs/manual/configuration.html#httpclient">Http Client Configuration</a>
 */
public class HttpClientConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientConfiguration.class);

    private static final String CTEST_GET_PARAM_FORMAT = "[CTEST][GET-PARAM] httpClient.{}";
    private static final String CTEST_SET_PARAM_FORMAT = "[CTEST][SET-PARAM] httpClient.{}";

    private String getStackTrace() {
        String stacktrace = " ";
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            stacktrace = stacktrace.concat(element.getClassName() + "\t");
        }
        return stacktrace;
    }

    @NotNull
    private Duration timeout = Duration.milliseconds(500);

    @NotNull
    private Duration connectionTimeout = Duration.milliseconds(500);

    @NotNull
    private Duration connectionRequestTimeout = Duration.milliseconds(500);

    @NotNull
    private Duration timeToLive = Duration.hours(1);

    private boolean cookiesEnabled = false;

    private boolean normalizeUriEnabled = true;

    @Min(1)
    @Max(Integer.MAX_VALUE)
    private int maxConnections = 1024;

    @Min(1)
    @Max(Integer.MAX_VALUE)
    private int maxConnectionsPerRoute = 1024;

    @NotNull
    private Duration keepAlive = Duration.milliseconds(0);

    @Min(0)
    @Max(1000)
    private int retries = 0;

    @NotNull
    private Optional<String> userAgent = Optional.empty();

    @Valid
    @Nullable
    private ProxyConfiguration proxyConfiguration;

    @NotNull
    private Duration validateAfterInactivityPeriod = Duration.microseconds(0);

    public Duration getKeepAlive() {
        String ctestParam = "keepAlive";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return keepAlive;
    }

    @Valid
    @Nullable
    private TlsConfiguration tlsConfiguration;

    @JsonProperty
    public void setKeepAlive(Duration keepAlive) {
        String ctestParam = "keepAlive";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.keepAlive = keepAlive;
    }

    @JsonProperty
    public int getMaxConnectionsPerRoute() {
        String ctestParam = "maxConnectionsPerRoute";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return maxConnectionsPerRoute;
    }

    @JsonProperty
    public void setMaxConnectionsPerRoute(int maxConnectionsPerRoute) {
        String ctestParam = "maxConnectionsPerRoute";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.maxConnectionsPerRoute = maxConnectionsPerRoute;
    }

    @JsonProperty
    public Duration getTimeout() {
        String ctestParam = "timeout";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return timeout;
    }

    @JsonProperty
    public Duration getConnectionTimeout() {
        String ctestParam = "connectionTimeout";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return connectionTimeout;
    }

    @JsonProperty
    public Duration getTimeToLive() {
        String ctestParam = "timeToLive";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return timeToLive;
    }

    @JsonProperty
    public boolean isCookiesEnabled() {
        String ctestParam = "cookiesEnabled";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return cookiesEnabled;
    }

    @JsonProperty
    public void setTimeout(Duration duration) {
        String ctestParam = "timeout";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.timeout = duration;
    }

    @JsonProperty
    public void setConnectionTimeout(Duration duration) {
        String ctestParam = "connectionTimeout";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.connectionTimeout = duration;
    }

    @JsonProperty
    public Duration getConnectionRequestTimeout() {
        String ctestParam = "connectionRequestTimeout";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return connectionRequestTimeout;
    }

    @JsonProperty
    public void setConnectionRequestTimeout(Duration connectionRequestTimeout) {
        String ctestParam = "connectionRequestTimeout";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    @JsonProperty
    public void setTimeToLive(Duration timeToLive) {
        String ctestParam = "timeToLive";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.timeToLive = timeToLive;
    }

    @JsonProperty
    public void setCookiesEnabled(boolean enabled) {
        String ctestParam = "cookiesEnabled";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.cookiesEnabled = enabled;
    }

    /**
     * @since 2.0
     * @deprecated
     */
    @Deprecated
    @JsonProperty
    public boolean isNormalizeUriEnabled() {
        String ctestParam = "normalizeUriEnabled";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return normalizeUriEnabled;
    }

    /**
     * @since 2.0
     * @deprecated
     */
    @Deprecated
    @JsonProperty
    public void setNormalizeUriEnabled(final boolean normalizeUriEnabled) {
        String ctestParam = "normalizeUriEnabled";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.normalizeUriEnabled = normalizeUriEnabled;
    }

    @JsonProperty
    public int getMaxConnections() {
        String ctestParam = "maxConnections";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return maxConnections;
    }

    @JsonProperty
    public void setMaxConnections(int maxConnections) {
        String ctestParam = "maxConnections";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.maxConnections = maxConnections;
    }

    @JsonProperty
    public int getRetries() {
        String ctestParam = "retries";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return retries;
    }

    @JsonProperty
    public void setRetries(int retries) {
        String ctestParam = "retries";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.retries = retries;
    }

    @JsonProperty
    public Optional<String> getUserAgent() {
        String ctestParam = "userAgent";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return userAgent;
    }

    @JsonProperty
    public void setUserAgent(Optional<String> userAgent) {
        String ctestParam = "userAgent";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.userAgent = userAgent;
    }

    @JsonProperty("proxy")
    @Nullable
    public ProxyConfiguration getProxyConfiguration() {
        return proxyConfiguration;
    }

    @JsonProperty("proxy")
    public void setProxyConfiguration(ProxyConfiguration proxyConfiguration) {
        this.proxyConfiguration = proxyConfiguration;
    }

    @JsonProperty
    public Duration getValidateAfterInactivityPeriod() {
        String ctestParam = "validateAfterInactivityPeriod";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return validateAfterInactivityPeriod;
    }

    @JsonProperty
    public void setValidateAfterInactivityPeriod(Duration validateAfterInactivityPeriod) {
        String ctestParam = "validateAfterInactivityPeriod";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.validateAfterInactivityPeriod = validateAfterInactivityPeriod;
    }

    @JsonProperty("tls")
    @Nullable
    public TlsConfiguration getTlsConfiguration() {
        return tlsConfiguration;
    }

    @JsonProperty("tls")
    public void setTlsConfiguration(TlsConfiguration tlsConfiguration) {
        this.tlsConfiguration = tlsConfiguration;
    }
}
