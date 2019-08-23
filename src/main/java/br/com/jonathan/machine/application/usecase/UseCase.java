package br.com.jonathan.machine.application.usecase;

@FunctionalInterface
public interface UseCase {

    String execute(String command);

}
