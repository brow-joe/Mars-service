package br.com.jonathan.machine.domain.service.action;

import br.com.jonathan.machine.domain.enumeration.DirectionEnum;
import br.com.jonathan.machine.domain.robot.MachineDomain;

public abstract class TurnAction implements Action {

    private final Integer STEP;

    public TurnAction(Integer STEP) {
        this.STEP = STEP;
    }

    @Override
    public void execute(MachineDomain robot) {
        int step = STEP % 4;
        int direction = (robot.getDirection().getValue() + step + 4) % 4;
        robot.setDirection(DirectionEnum.getByValue(direction));
    }

}
