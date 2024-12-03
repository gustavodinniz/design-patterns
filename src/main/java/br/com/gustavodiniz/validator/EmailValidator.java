package br.com.gustavodiniz.validator;

import br.com.gustavodiniz.Main;
import br.com.gustavodiniz.domain.User;

import java.util.logging.Logger;

public class EmailValidator implements Validator {

    private static final Logger logger = Logger.getLogger(EmailValidator.class.getName());

    private Validator next;

    public boolean validate(User user) {
        logger.info("Validating email...");
        if (user.getEmail() != null && user.getEmail().contains("@")) {
            logger.info("Email is valid.");
            return this.next != null && this.next.validate(user);
        } else {
            logger.info("Invalid email.");
            return false;
        }
    }

    public void setNext(Validator next) {
        this.next = next;
    }
}
