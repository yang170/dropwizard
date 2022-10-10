package io.dropwizard.health;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.util.Duration;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Schedule {
    private static final Logger LOGGER = LoggerFactory.getLogger(Schedule.class);

    private static final String CTEST_GET_PARAM_FORMAT = "[CTEST][GET-PARAM] health.healthChecks.schedule.{}";
    private static final String CTEST_SET_PARAM_FORMAT = "[CTEST][SET-PARAM] health.healthChecks.schedule.{}";

    @Nullable
    @JsonProperty
    private Duration initialDelay = null;

    @NotNull
    @JsonProperty
    private Duration checkInterval = Duration.seconds(5);

    @NotNull
    @JsonProperty
    private Duration downtimeInterval = Duration.seconds(30);

    @Min(0)
    @JsonProperty
    private int failureAttempts = 3;

    @Min(0)
    @JsonProperty
    private int successAttempts = 2;

    private String getStackTrace() {
        String stacktrace = " ";
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            stacktrace = stacktrace.concat(element.getClassName() + "\t");
        }
        return stacktrace;
    }

    public Duration getInitialDelay() {
        String ctestParam = "initialDelay";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);

        // default to checkInterval value
        return initialDelay == null ? getCheckInterval() : initialDelay;
    }

    public void setInitialDelay(Duration initialDelay) {
        String ctestParam = "initialDelay";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.initialDelay = initialDelay;
    }

    public Duration getCheckInterval() {
        String ctestParam = "checkInterval";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return checkInterval;
    }

    public void setCheckInterval(final Duration checkInterval) {
        String ctestParam = "checkInterval";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.checkInterval = checkInterval;
    }

    public Duration getDowntimeInterval() {
        String ctestParam = "downtimeInterval";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return downtimeInterval;
    }

    public void setDowntimeInterval(final Duration downtimeInterval) {
        String ctestParam = "downtimeInterval";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.downtimeInterval = downtimeInterval;
    }

    public int getFailureAttempts() {
        String ctestParam = "failureAttempts";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return failureAttempts;
    }

    public void setFailureAttempts(final int failureAttempts) {
        String ctestParam = "failureAttempts";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.failureAttempts = failureAttempts;
    }

    public int getSuccessAttempts() {
        String ctestParam = "successAttempts";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return successAttempts;
    }

    public void setSuccessAttempts(final int successAttempts) {
        String ctestParam = "successAttempts";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.successAttempts = successAttempts;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        final Schedule schedule = (Schedule) o;
        return failureAttempts == schedule.failureAttempts &&
            successAttempts == schedule.successAttempts &&
            Objects.equals(initialDelay, schedule.initialDelay) &&
            Objects.equals(checkInterval, schedule.checkInterval) &&
            Objects.equals(downtimeInterval, schedule.downtimeInterval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialDelay, checkInterval, downtimeInterval, failureAttempts, successAttempts);
    }
}
