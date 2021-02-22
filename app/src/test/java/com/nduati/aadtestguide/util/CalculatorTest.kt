package com.nduati.aadtestguide.util

import junit.framework.TestCase
import org.junit.Test


class CalculatorTest : TestCase() {
    val calc : Calculator = Calculator()

    @Test
    fun testAdd() {
        assertEquals(4, calc.add(2,2))
    }

    @Test
    fun testSubtract() {
        assertEquals(1, calc.subtract(47,46))
    }

    @Test
    fun testDivid() {
        assertEquals(4, calc.divid(36,9))
    }

    @Test
    fun testMulti() {
        assertEquals(15, calc.multi(5,3))
    }
}