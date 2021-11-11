package com.company;

import org.junit.Assert;

import static com.company.Main.sum;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void TestSum() {
        int[][] Z= {{1,2},{3,4}} ;
        int t = sum(Z, 2, 2);
        int ex = 10;
        Assert.assertEquals(ex,t);
    }
}