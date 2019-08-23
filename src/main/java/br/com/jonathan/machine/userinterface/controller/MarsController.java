package br.com.jonathan.machine.userinterface.controller;

import br.com.jonathan.machine.application.usecase.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mars")
public class MarsController {

    @Autowired
    private UseCase useCase;

    @PostMapping(value = "/{command}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> move(@PathVariable("command") String command) {
        return ResponseEntity.ok(
            useCase.execute(command)
        );
    }

}
