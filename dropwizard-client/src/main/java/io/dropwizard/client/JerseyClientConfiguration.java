package io.dropwizard.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.validation.ValidationMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * The configuration class used by {@link JerseyClientBuilder}. Extends
 * {@link HttpClientConfiguration}.
 *
 * @see HttpClientConfiguration
 * @see <a href="http://dropwizard.io/1.0.2/docs/manual/configuration.html#jerseyclient">Jersey Client Configuration</a>
 */
public class JerseyClientConfiguration extends HttpClientConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(JerseyClientConfiguration.class);

    private static final String CTEST_GET_PARAM_FORMAT = "[CTEST][GET-PARAM] jerseyClient.{}";
    private static final String CTEST_SET_PARAM_FORMAT = "[CTEST][SET-PARAM] jerseyClient.{}";

    private String getStackTrace() {
        String stacktrace = " ";
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            stacktrace = stacktrace.concat(element.getClassName() + "\t");
        }
        return stacktrace;
    }

    @Min(1)
    @Max(16 * 1024)
    private int minThreads = 1;

    @Min(1)
    @Max(16 * 1024)
    private int maxThreads = 128;

    @Min(1)
    @Max(16 * 1024)
    private int workQueueSize = 8;

    private boolean gzipEnabled = true;

    private boolean gzipEnabledForRequests = true;

    private boolean chunkedEncodingEnabled = true;

    @JsonProperty
    public int getMinThreads() {
        String ctestParam = "minThreads";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return minThreads;
    }

    @JsonProperty
    public void setMinThreads(int minThreads) {
        String ctestParam = "minThreads";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.minThreads = minThreads;
    }

    @JsonProperty
    public int getMaxThreads() {
        String ctestParam = "maxThreads";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return maxThreads;
    }

    @JsonProperty
    public void setMaxThreads(int maxThreads) {
        String ctestParam = "maxThreads";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.maxThreads = maxThreads;
    }

    @JsonProperty
    public boolean isGzipEnabled() {
        String ctestParam = "gzipEnabled";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return gzipEnabled;
    }

    @JsonProperty
    public void setGzipEnabled(boolean enabled) {
        String ctestParam = "gzipEnabled";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.gzipEnabled = enabled;
    }

    @JsonProperty
    public boolean isGzipEnabledForRequests() {
        String ctestParam = "gzipEnabledForRequests";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return gzipEnabledForRequests;
    }

    @JsonProperty
    public void setGzipEnabledForRequests(boolean enabled) {
        String ctestParam = "gzipEnabledForRequests";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.gzipEnabledForRequests = enabled;
    }

    @JsonProperty
    public boolean isChunkedEncodingEnabled() {
        String ctestParam = "chunkedEncodingEnabled";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return chunkedEncodingEnabled;
    }

    @JsonProperty
    public void setChunkedEncodingEnabled(final boolean chunkedEncodingEnabled) {
        String ctestParam = "chunkedEncodingEnabled";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.chunkedEncodingEnabled = chunkedEncodingEnabled;
    }

    @JsonProperty
    public int getWorkQueueSize() {
        String ctestParam = "workQueueSize";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return workQueueSize;
    }

    @JsonProperty
    public void setWorkQueueSize(int workQueueSize) {
        String ctestParam = "workQueueSize";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.workQueueSize = workQueueSize;
    }

    @JsonIgnore
    @ValidationMethod(message = ".minThreads must be less than or equal to maxThreads")
    public boolean isThreadPoolSizedCorrectly() {
        return minThreads <= maxThreads;
    }

    @JsonIgnore
    @ValidationMethod(message = ".gzipEnabledForRequests requires gzipEnabled set to true")
    public boolean isCompressionConfigurationValid() {
        return !gzipEnabledForRequests || gzipEnabled;
    }
}
