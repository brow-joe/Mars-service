package br.com.jonathan.machine.domain.service.action;

import br.com.jonathan.machine.domain.robot.MachineDomain;
import org.springframework.stereotype.Service;

@Service
public class MoveForwardAction implements Action {

    @Override
    public void execute(MachineDomain robot) {
        switch (robot.getDirection()) {
            case NORTH:
                robot.increaseY();
                break;
            case SOUTH:
                robot.decreaseY();
                break;
            case EAST:
                robot.increaseX();
                break;
            case WEST:
                robot.decreaseX();
                break;
        }
    }

}
