package br.com.gustavodiniz.validator;

import br.com.gustavodiniz.domain.User;

import java.util.logging.Logger;

public class UsernameValidator implements Validator {

    private static final Logger logger = Logger.getLogger(UsernameValidator.class.getName());

    private Validator next;

    public boolean validate(User user) {
        logger.info("Validating username...");
        if (user.getUsername() != null && user.getUsername().length() >= 4) {
            logger.info("Username is at least 4 characters long.");
            return this.next != null && this.next.validate(user);
        } else {
            logger.info("Username must be at least 4 characters long.");
            return false;
        }
    }

    public void setNext(Validator next) {
        this.next = next;
    }
}
