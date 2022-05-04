package com.kruger.oauthauthorizationserver.util;

public class Messages {
    public enum Info {
        NOT_FOUND_USER("User not found."),
        BAD_CREDENTIALS("Bad Credentials")
        ;

        private final String text;

        /**
         * @param text
         */
        Info(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
