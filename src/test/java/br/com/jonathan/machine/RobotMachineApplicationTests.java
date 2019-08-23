package br.com.jonathan.machine;

import br.com.jonathan.machine.application.exceptions.ActionNotFoundException;
import br.com.jonathan.machine.application.exceptions.InvalidPositionException;
import br.com.jonathan.machine.userinterface.controller.MarsController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotMachineApplicationTests extends Assert {

    @Autowired
    private MarsController controller;

    @Test
    public void testPositionOne() {
        ResponseEntity<String> response = controller.move("MMRMMRMM");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.hasBody());
        assertEquals("(2, 0, S)", response.getBody());
    }

    @Test
    public void testPositionTwo() {
        ResponseEntity<String> response = controller.move("MML");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.hasBody());
        assertEquals("(0, 2, W)", response.getBody());
        response = controller.move("MML");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.hasBody());
        assertEquals("(0, 2, W)", response.getBody());
    }

    @Test(expected = ActionNotFoundException.class)
    public void testFailureOne() {
        controller.move("AAA");
    }

    @Test(expected = InvalidPositionException.class)
    public void testFailureTwo() {
        controller.move("MMMMMMMMMMMMMMMMMMMMMMMM");
    }

}
