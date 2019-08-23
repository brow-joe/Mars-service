package br.com.jonathan.machine.domain.factory;

import br.com.jonathan.machine.domain.service.action.Action;

@FunctionalInterface
public interface Factory {

    Action with(char code);

}
