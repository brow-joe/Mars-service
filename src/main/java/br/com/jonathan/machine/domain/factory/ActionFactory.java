package br.com.jonathan.machine.domain.factory;

import br.com.jonathan.machine.application.exceptions.ActionNotFoundException;
import br.com.jonathan.machine.domain.service.action.Action;
import br.com.jonathan.machine.domain.service.action.MoveForwardAction;
import br.com.jonathan.machine.domain.service.action.TurnLeftAction;
import br.com.jonathan.machine.domain.service.action.TurnRightAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionFactory implements Factory {

    @Autowired
    private MoveForwardAction forward;

    @Autowired
    private TurnRightAction turnRight;

    @Autowired
    private TurnLeftAction turnLeft;

    @Override
    public Action with(char code) {
        switch (code) {
            case 'M':
                return forward;
            case 'R':
                return turnRight;
            case 'L':
                return turnLeft;
            default:
                throw new ActionNotFoundException();
        }
    }

}
