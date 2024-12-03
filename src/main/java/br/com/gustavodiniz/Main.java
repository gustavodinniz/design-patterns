package br.com.gustavodiniz;

import br.com.gustavodiniz.domain.User;
import br.com.gustavodiniz.validator.ValidatorChainBuilder;

import java.util.logging.Logger;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Starting validation chain...");
        var builder = new ValidatorChainBuilder();
        var validatorChain = builder.build();

        var invalidUser = new User("existing@example.com", "1234Pass", "john");
        var validUser = new User("test@example.com", "1234Pass", "john");

        if (validatorChain.validate(invalidUser)) {
            logger.info("Valid user.");
        } else {
            logger.info("Invalid user.");
        }
    }
}