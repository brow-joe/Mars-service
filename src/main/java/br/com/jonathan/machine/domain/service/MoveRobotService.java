package br.com.jonathan.machine.domain.service;

import br.com.jonathan.machine.application.exceptions.CommandNotFoundException;
import br.com.jonathan.machine.domain.factory.Factory;
import br.com.jonathan.machine.domain.robot.MachineDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MoveRobotService implements RobotService {

    @Autowired
    private Factory factory;

    @Override
    public String move(MachineDomain robot, String command) {
        if (Objects.isNull(command)) {
            throw new CommandNotFoundException();
        }
        return robot.move(command, factory::with);
    }

}
