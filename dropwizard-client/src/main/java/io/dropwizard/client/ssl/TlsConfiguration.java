package io.dropwizard.client.ssl;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.validation.ValidationMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.util.List;
import java.util.Optional;

public class TlsConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(TlsConfiguration.class);

    private static final String CTEST_GET_PARAM_FORMAT = "[CTEST][GET-PARAM] httpClient.tls.{}";
    private static final String CTEST_SET_PARAM_FORMAT = "[CTEST][SET-PARAM] httpClient.tls.{}";

    private String getStackTrace() {
        String stacktrace = " ";
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            stacktrace = stacktrace.concat(element.getClassName() + "\t");
        }
        return stacktrace;
    }

    @NotEmpty
    private String protocol = "TLSv1.2";

    @Nullable
    private String provider;

    @Nullable
    private File keyStorePath;

    @Nullable
    private String keyStorePassword;

    @NotEmpty
    private String keyStoreType = "JKS";

    @Nullable
    private String keyStoreProvider;

    @Nullable
    private File trustStorePath;

    @Nullable
    private String trustStorePassword;

    @NotEmpty
    private String trustStoreType = "JKS";

    @Nullable
    private String trustStoreProvider;

    private boolean trustSelfSignedCertificates = false;

    private boolean verifyHostname = true;

    @Nullable
    private List<String> supportedProtocols = null;

    @Nullable
    private List<String> supportedCiphers = null;

    @Nullable
    private String certAlias = null;

    @JsonProperty
    public void setTrustSelfSignedCertificates(boolean trustSelfSignedCertificates) {
        String ctestParam = "trustSelfSignedCertificates";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.trustSelfSignedCertificates = trustSelfSignedCertificates;
    }

    @JsonProperty
    public boolean isTrustSelfSignedCertificates() {
        String ctestParam = "trustSelfSignedCertificates";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return trustSelfSignedCertificates;
    }

    @JsonProperty
    @Nullable
    public File getKeyStorePath() {
        String ctestParam = "keyStorePath";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return keyStorePath;
    }

    @JsonProperty
    public void setKeyStorePath(File keyStorePath) {
        String ctestParam = "keyStorePath";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.keyStorePath = keyStorePath;
    }

    @JsonProperty
    @Nullable
    public String getKeyStorePassword() {
        String ctestParam = "keyStorePassword";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return keyStorePassword;
    }

    @JsonProperty
    public void setKeyStorePassword(String keyStorePassword) {
        String ctestParam = "keyStorePassword";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.keyStorePassword = keyStorePassword;
    }

    @JsonProperty
    public String getKeyStoreType() {
        String ctestParam = "keyStoreType";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return keyStoreType;
    }

    @JsonProperty
    public void setKeyStoreType(String keyStoreType) {
        String ctestParam = "keyStoreType";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.keyStoreType = keyStoreType;
    }

    @JsonProperty
    public String getTrustStoreType() {
        String ctestParam = "trustStoreType";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return trustStoreType;
    }

    @JsonProperty
    public void setTrustStoreType(String trustStoreType) {
        String ctestParam = "trustStoreType";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.trustStoreType = trustStoreType;
    }

    @JsonProperty
    @Nullable
    public File getTrustStorePath() {
        String ctestParam = "trustStorePath";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return trustStorePath;
    }

    @JsonProperty
    public void setTrustStorePath(File trustStorePath) {
        String ctestParam = "trustStorePath";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.trustStorePath = trustStorePath;
    }

    @JsonProperty
    @Nullable
    public String getTrustStorePassword() {
        String ctestParam = "trustStorePassword";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return trustStorePassword;
    }

    @JsonProperty
    public void setTrustStorePassword(String trustStorePassword) {
        String ctestParam = "trustStorePassword";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.trustStorePassword = trustStorePassword;
    }

    @JsonProperty
    public boolean isVerifyHostname() {
        String ctestParam = "verifyHostname";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return verifyHostname;
    }

    @JsonProperty
    public void setVerifyHostname(boolean verifyHostname) {
        String ctestParam = "verifyHostname";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.verifyHostname = verifyHostname;
    }

    @JsonProperty
    public String getProtocol() {
        String ctestParam = "protocol";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return protocol;
    }

    @JsonProperty
    public void setProtocol(String protocol) {
        String ctestParam = "protocol";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.protocol = protocol;
    }

    @JsonProperty
    @Nullable
    public String getProvider() {
        String ctestParam = "provider";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return provider;
    }

    @JsonProperty
    public void setProvider(@Nullable String provider) {
        String ctestParam = "provider";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.provider = provider;
    }

    @Nullable
    @JsonProperty
    public List<String> getSupportedCiphers() {
        String ctestParam = "supportedCiphers";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return supportedCiphers;
    }

    @JsonProperty
    public void setSupportedCiphers(@Nullable List<String> supportedCiphers) {
        String ctestParam = "supportedCiphers";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.supportedCiphers = supportedCiphers;
    }

    @Nullable
    @JsonProperty
    public List<String> getSupportedProtocols() {
        String ctestParam = "supportedProtocols";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return supportedProtocols;
    }

    @JsonProperty
    public void setSupportedProtocols(@Nullable List<String> supportedProtocols) {
        String ctestParam = "supportedProtocols";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.supportedProtocols = supportedProtocols;
    }

    @Nullable
    @JsonProperty
    public String getCertAlias() {
        String ctestParam = "certAlias";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return certAlias;
    }

    @JsonProperty
    public void setCertAlias(@Nullable String certAlias) {
        String ctestParam = "certAlias";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.certAlias = certAlias;
    }

    @ValidationMethod(message = "keyStorePassword should not be null or empty if keyStorePath not null")
    public boolean isValidKeyStorePassword() {
        return keyStorePath == null
            || keyStoreType.startsWith("Windows-")
            || Optional.ofNullable(keyStorePassword).filter(s -> !s.isEmpty()).isPresent();
    }

    @ValidationMethod(message = "trustStorePassword should not be null or empty if trustStorePath not null")
    public boolean isValidTrustStorePassword() {
        return trustStorePath == null
            || trustStoreType.startsWith("Windows-")
            || Optional.ofNullable(trustStorePassword).filter(s -> !s.isEmpty()).isPresent();
    }

    /**
     * @since 2.0
     */
    @Nullable
    public String getKeyStoreProvider() {
        String ctestParam = "keyStoreProvider";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return keyStoreProvider;
    }

    /**
     * @since 2.0
     */
    public void setKeyStoreProvider(@Nullable String keyStoreProvider) {
        String ctestParam = "keyStoreProvider";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.keyStoreProvider = keyStoreProvider;
    }

    /**
     * @since 2.0
     */
    @Nullable
    public String getTrustStoreProvider() {
        String ctestParam = "trustStoreProvider";
        LOGGER.warn(CTEST_GET_PARAM_FORMAT, ctestParam);
        return trustStoreProvider;
    }

    /**
     * @since 2.0
     */
    public void setTrustStoreProvider(@Nullable String trustStoreProvider) {
        String ctestParam = "trustStoreProvider";
        LOGGER.warn(CTEST_SET_PARAM_FORMAT, ctestParam + getStackTrace());
        this.trustStoreProvider = trustStoreProvider;
    }
}
