package br.com.gustavodiniz.validator;

import br.com.gustavodiniz.domain.User;

import java.util.logging.Logger;

public class RequiredFieldsValidator implements Validator {

    private static final Logger logger = Logger.getLogger(RequiredFieldsValidator.class.getName());

    private Validator next;

    public boolean validate(User user) {
        logger.info("Validating required fields...");
        if (user.getEmail() != null && user.getPassword() != null && user.getUsername() != null) {
            logger.info("All fields are present.");
            return this.next != null && this.next.validate(user);
        } else {
            logger.info("All fields are required.");
            return false;
        }
    }

    public void setNext(Validator next) {
        this.next = next;
    }
}
