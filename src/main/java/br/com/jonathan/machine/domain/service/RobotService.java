package br.com.jonathan.machine.domain.service;

import br.com.jonathan.machine.domain.robot.MachineDomain;

@FunctionalInterface
public interface RobotService {

    String move(MachineDomain robot, String command);

}
