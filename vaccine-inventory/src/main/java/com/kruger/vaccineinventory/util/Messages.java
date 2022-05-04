package com.kruger.vaccineinventory.util;

public class Messages {
    public enum Errors {
        INVALID_EMAIL("Invalid email."),
        INVALID_NAME("Invalid name."),
        INVALID_SECOND_NAME("Invalid second name."),
        INVALID_SURNAME("Invalid surname."),
        INVALID_SECOND_SURNAME("Invalid second surname."),
        INVALID_IDENTIFICATION("Invalid identification number."),
        DUPLICATED_IDENTIFICATION("Identification number is already registered."),
        INVALID_PHONE_TYPE("Invalid phone type."),
        INVALID_VACCINE_TYPE("Invalid vaccine type."),
        INVALID_DATE_FORMAT("Invalid date format, must be (yyyy-mm-dd).")
        ;

        private final String text;

        /**
         * @param text
         */
        Errors(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum NotFound {
        NOT_FOUND_UPDATE("Employee not found to update."),
        NOT_FOUND_DELETE("Employee not found to delete."),
        NOT_FOUND_GET_BY_ID("Employee not found.")
        ;

        private final String text;

        /**
         * @param text
         */
        NotFound(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum Required {
        EMPLOYEE_NAME("Employee name is required."),
        EMPLOYEE_SECOND_NAME("Employee second name is required."),
        EMPLOYEE_SURNAME("Employee surname is required."),
        EMPLOYEE_SECOND_SURNAME("Employee second surname is required."),
        EMPLOYEE_IDENTIFICATION("Employee identification is required."),
        EMPLOYEE_EMAIL("Employee email is required."),
        PHONE_TYPE("Phone type is required."),
        PHONE_NUMBER("Phone number is required."),
        ADDRESS_DESCRIPTION("Address description is required."),
        VACCINE_INFORMATION("You must submit valid information on at least one vaccine.")
        ;

        private final String text;

        /**
         * @param text
         */
        Required(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
