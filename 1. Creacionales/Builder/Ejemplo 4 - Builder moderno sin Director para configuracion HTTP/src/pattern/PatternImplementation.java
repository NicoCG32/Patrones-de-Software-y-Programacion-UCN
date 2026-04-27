package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class HttpClientConfig {
        private final String baseUrl;
        private final int timeoutSeconds;
        private final int retries;
        private final String token;
        private final boolean tlsRequired;

        private HttpClientConfig(Builder builder) {
            this.baseUrl = builder.baseUrl;
            this.timeoutSeconds = builder.timeoutSeconds;
            this.retries = builder.retries;
            this.token = builder.token;
            this.tlsRequired = builder.tlsRequired;
        }

        public String describe() {
            return baseUrl + " timeout=" + timeoutSeconds + " retries=" + retries
                + " token=" + (token != null) + " tls=" + tlsRequired;
        }

        public static Builder builder(String baseUrl) {
            return new Builder(baseUrl);
        }

        public static class Builder {
            private final String baseUrl;
            private int timeoutSeconds = 30;
            private int retries = 1;
            private String token;
            private boolean tlsRequired = true;

            private Builder(String baseUrl) {
                this.baseUrl = baseUrl;
            }

            public Builder timeoutSeconds(int timeoutSeconds) {
                this.timeoutSeconds = timeoutSeconds;
                return this;
            }

            public Builder retries(int retries) {
                this.retries = retries;
                return this;
            }

            public Builder bearerToken(String token) {
                this.token = token;
                return this;
            }

            public Builder allowInsecureLocalhost() {
                this.tlsRequired = false;
                return this;
            }

            public HttpClientConfig build() {
                if (baseUrl == null || baseUrl.isBlank()) {
                    throw new IllegalStateException("baseUrl es obligatoria");
                }
                if (timeoutSeconds <= 0) {
                    throw new IllegalStateException("timeoutSeconds debe ser positivo");
                }
                return new HttpClientConfig(this);
            }
        }
    }
}
