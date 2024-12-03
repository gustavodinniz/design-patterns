package br.com.gustavodiniz.validator;

import br.com.gustavodiniz.domain.User;

public interface Validator {

    boolean validate(User user);

    void setNext(Validator next);
}
