package br.com.jonathan.machine.domain.service.action;

import br.com.jonathan.machine.domain.robot.MachineDomain;

@FunctionalInterface
public interface Action {

    void execute(MachineDomain robot);

}
