package br.com.jonathan.machine.application.usecase.robot;

import br.com.jonathan.machine.application.usecase.UseCase;
import br.com.jonathan.machine.domain.robot.MachineDomain;
import br.com.jonathan.machine.domain.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoveRobotUseCase implements UseCase {

    @Autowired
    private RobotService service;

    @Override
    public String execute(String command) {
        return service.move(new MachineDomain(), command);
    }

}
