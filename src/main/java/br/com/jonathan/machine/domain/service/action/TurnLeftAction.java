package br.com.jonathan.machine.domain.service.action;

import org.springframework.stereotype.Service;

@Service
public class TurnLeftAction extends TurnAction {

    public TurnLeftAction() {
        super(-1);
    }

}
