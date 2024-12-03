package br.com.gustavodiniz.validator;

import br.com.gustavodiniz.domain.User;

import java.util.logging.Logger;

public class UniqueEmailValidator implements Validator {

    private static final Logger logger = Logger.getLogger(UniqueEmailValidator.class.getName());

    private static final String EMAIL = "existing@example.com";
    private Validator next;


    public boolean validate(User user) {
        logger.info("Validating email uniqueness...");
        if (EMAIL.equals(user.getEmail())) {
            logger.info("Email is already in use.");
            return false;
        } else {
            logger.info("Email is unique.");
            return this.next != null && this.next.validate(user);
        }
    }

    public void setNext(Validator next) {
        this.next = next;
    }
}
