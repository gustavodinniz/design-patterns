package br.com.gustavodiniz.validator;

public class ValidatorChainBuilder {

    public Validator build() {
        Validator requiredFieldsValidator = new RequiredFieldsValidator();
        Validator emailValidator = new EmailValidator();
        Validator passwordValidator = new PasswordValidator();
        Validator usernameValidator = new UsernameValidator();
        Validator uniqueEmailValidator = new UniqueEmailValidator();
        requiredFieldsValidator.setNext(emailValidator);
        emailValidator.setNext(passwordValidator);
        passwordValidator.setNext(usernameValidator);
        usernameValidator.setNext(uniqueEmailValidator);
        return requiredFieldsValidator;
    }
}
