package com.mn.springbootsampler.bdd.steps;

import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestSteps {

    @When("I send a message {string}")
    public void iSendAMessage(String message) throws Exception {
        log.info("hello");
    }
}
