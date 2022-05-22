package com.qa.automation.cucumber.generate;

import com.qa.automation.cucumber.generate.name.Counter;

public class InstanceCounter implements Counter {

    private int counter = 1;

    public int next() {
        return counter++;
    }

}