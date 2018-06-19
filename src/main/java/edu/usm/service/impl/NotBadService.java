package edu.usm.service.impl;

import edu.usm.service.AwesomeService;
import org.springframework.stereotype.Component;

@Component
public class NotBadService implements AwesomeService {
    @Override
    public String pleaseReturnSomething() {
        return "It's just not bad.";
    }
}
