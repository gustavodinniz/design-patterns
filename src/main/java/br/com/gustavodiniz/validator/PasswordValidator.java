package br.com.gustavodiniz.validator;

import br.com.gustavodiniz.domain.User;

import java.util.logging.Logger;

public class PasswordValidator implements Validator {

    private static final Logger logger = Logger.getLogger(PasswordValidator.class.getName());

    private Validator next;

    public boolean validate(User user) {
        logger.info("Validating password...");
        if (user.getPassword() != null && user.getPassword().length() >= 8) {
            logger.info("Password is at least 8 characters long.");
            if (user.getPassword().matches(".*[A-Z].*") && user.getPassword().matches(".*[0-9].*")) {
                logger.info("Password contains at least one capital letter and one number.");
                return this.next != null && this.next.validate(user);
            } else {
                logger.info("Password must contain at least one capital letter and one number.");
                return false;
            }
        } else {
            logger.info("Password must be at least 8 characters long.");
            return false;
        }
    }

    public void setNext(Validator next) {
        this.next = next;
    }
}
