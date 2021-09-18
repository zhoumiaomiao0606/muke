package com.course.testng.suite;

import org.testng.annotations.Test;

public class timeouttest {
    @Test(timeOut = 3000)

    public void timetest() throws InterruptedException {
        Thread.sleep(4000);
    }


}
