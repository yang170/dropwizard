package io.dropwizard.health;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HealthCheckConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHealthFactory.class);

    private static final String CTEST_GET_PARAM_FORMAT = "[CTEST][GET-PARAM] healthChecks.{}";
    private static final String CTEST_SET_PARAM_FORMAT = "[CTEST][SET-PARAM] healthChecks.{}";

    @NotNull
    @Size(min = 1)
    @JsonProperty
    private String name = "";

    @NotNull
    @JsonProperty
    private HealthCheckType type = HealthCheckType.READY;

    @JsonProperty
    private boolean critical = false;

    @JsonProperty
    private boolean initialState = true;

    @Valid
    @NotNull
    @JsonProperty
    private Schedule schedule = new Schedule();

    private String getStackTrace() {
        String stacktrace = " ";
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            stacktrace = stacktrace.concat(element.getClassName() + "\t");
        }
        return stacktrace;
    }

    public String getName() {
        String ctestParam = "name";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return name;
    }

    public void setName(final String name) {
        String ctestParam = "name";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.name = name;
    }

    public HealthCheckType getType() {
        String ctestParam = "type";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return type;
    }

    public void setType(HealthCheckType type) {
        String ctestParam = "type";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.type = type;
    }

    public boolean isCritical() {
        String ctestParam = "critical";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return critical;
    }

    public void setCritical(final boolean critical) {
        String ctestParam = "critical";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.critical = critical;
    }

    public boolean isInitialState() {
        String ctestParam = "initialState";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return initialState;
    }

    public void setInitialState(boolean initialState) {
        String ctestParam = "initialState";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.initialState = initialState;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(final Schedule schedule) {
        this.schedule = schedule;
    }
}
