package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class UserProfile {
        private final String username;
        private final String displayName;
        private final String locale;
        private final boolean twoFactorEnabled;
        private final boolean newsletterEnabled;

        private UserProfile(Builder builder) {
            this.username = builder.username;
            this.displayName = builder.displayName;
            this.locale = builder.locale;
            this.twoFactorEnabled = builder.twoFactorEnabled;
            this.newsletterEnabled = builder.newsletterEnabled;
        }

        public String describe() {
            return username + " (" + displayName + ") locale=" + locale
                + " 2FA=" + twoFactorEnabled + " newsletter=" + newsletterEnabled;
        }

        public static Builder builder(String username) {
            return new Builder(username);
        }

        public static class Builder {
            private final String username;
            private String displayName;
            private String locale = "es-CL";
            private boolean twoFactorEnabled;
            private boolean newsletterEnabled = true;

            private Builder(String username) {
                this.username = username;
                this.displayName = username;
            }

            public Builder displayName(String displayName) {
                this.displayName = displayName;
                return this;
            }

            public Builder locale(String locale) {
                this.locale = locale;
                return this;
            }

            public Builder enableTwoFactor() {
                this.twoFactorEnabled = true;
                return this;
            }

            public Builder disableNewsletter() {
                this.newsletterEnabled = false;
                return this;
            }

            public UserProfile build() {
                if (username == null || username.isBlank()) {
                    throw new IllegalStateException("username es obligatorio");
                }
                return new UserProfile(this);
            }
        }
    }
}
