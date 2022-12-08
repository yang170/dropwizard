package io.dropwizard.health.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.health.HealthEnvironment;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.jetty.setup.ServletEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * A servlet-based implementation of {@link HealthResponderFactory}, to respond to health check requests.
 */
@JsonTypeName("servlet")
public class ServletHealthResponderFactory implements HealthResponderFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServletHealthResponderFactory.class);

    private static final String CTEST_GET_PARAM_FORMAT = "[CTEST][GET-PARAM] health.responder.{}";
    private static final String CTEST_SET_PARAM_FORMAT = "[CTEST][SET-PARAM] health.responder.{}";

    static final String SERVLET_SUFFIX = "-servlet";

    @JsonProperty
    private boolean cacheControlEnabled = true;

    @JsonProperty
    private String cacheControlValue = "no-store";

    private String getStackTrace() {
        String stacktrace = " ";
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            stacktrace = stacktrace.concat(element.getClassName() + "\t");
        }
        return stacktrace;
    }

    public boolean isCacheControlEnabled() {
        String ctestParam = "cacheControlEnabled";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return cacheControlEnabled;
    }

    public void setCacheControlEnabled(boolean cacheControlEnabled) {
        String ctestParam = "cacheControlEnabled";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.cacheControlEnabled = cacheControlEnabled;
    }

    public String getCacheControlValue() {
        String ctestParam = "cacheControlValue";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return cacheControlValue;
    }

    public void setCacheControlValue(String cacheControlValue) {
        String ctestParam = "cacheControlValue";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.cacheControlValue = cacheControlValue;
    }

    @Override
    public void configure(final String name, final Collection<String> healthCheckUrlPaths,
                          final HealthResponseProvider healthResponseProvider,
                          final HealthEnvironment health, final JerseyEnvironment jersey,
                          final ServletEnvironment servlets, final ObjectMapper mapper) {
        final ServletHealthResponder servlet = new ServletHealthResponder(healthResponseProvider, cacheControlEnabled,
            cacheControlValue);
        servlets
            .addServlet(name + SERVLET_SUFFIX, servlet)
            .addMapping(healthCheckUrlPaths.toArray(new String[0]));
    }
}
