package cm;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DoyleCraigTestTask3 {
//public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate,
// ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods);

//public BigDecimal calculate(Period periodStay);

    @Test
    public void calcTestCase1() {
//startTime Earlier than endTime and between 0 and 24
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(0);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(10, 11));
        reducedPeriods.add(new Period(0, 1));

        Rate test = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);

        assertEquals(1, test.calculate(normalPeriods.get(0)).intValue());


    }

    @Test(expected = IllegalArgumentException.class)
    public void calcTestCase2() {
//startTime greater than endTime
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(0);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, 10));
        reducedPeriods.add(new Period(0, 0));

        Rate test = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);

        test.calculate(normalPeriods.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcTestCase3() {
//startTime is less than 0
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(0);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(-3, 10));
        reducedPeriods.add(new Period(0, 0));

        Rate test = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);

        test.calculate(normalPeriods.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcTestCase4() {
//endTime is less than 0
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(0);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, -3));
        reducedPeriods.add(new Period(0, 0));

        Rate test = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);

        test.calculate(normalPeriods.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcTestCase5() {
//endTime is greater than 24
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(0);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, 27));
        reducedPeriods.add(new Period(0, 0));

        Rate test = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);

        test.calculate(normalPeriods.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcTestCase6() {
//startTime is not a number
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(0);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period('c', 12));
        reducedPeriods.add(new Period(0, 0));

        Rate test = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);

        test.calculate(normalPeriods.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcTestCase7() {
//endTime is not a number
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(0);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(12, '&'));
        reducedPeriods.add(new Period(0, 0));

        Rate test = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);

        test.calculate(normalPeriods.get(0));
    }


//public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate,
// ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods);

    @Test(expected = IllegalArgumentException.class)
    public void testCase1() {
        //normalRate is 0
        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(1);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }


    @Test
    public void testCase2() {
        //reduceRate is 0
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(0);

        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCase3() {
        //normalRate is less than 0
        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCase4() {
        //reduceRate is less than 0
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(-1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase5() {
        //reduceRate greater than normalRate
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test
    public void testCase6() {
        //normalRate greater than reduceRate
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase7() {
        //normalRate equal to reduceRate
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase8() {
        //normalRate is null
        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase9() {
        //reduceRate is null
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = null;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase10() {
        //normalPeriod and reducePeriod overlap
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(11, 14));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase11() {
        //normalPeriod overlaps itself
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 18));
        normalPeriods.add(new Period(19, 22));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase12() {
        //reducePeriod overlaps itself
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(7, 12));
        reducedPeriods.add(new Period(10, 15));
        normalPeriods.add(new Period(16, 19));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test
    public void testCase13() {
        //reducePeriod startTime is less than endTime
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test
    public void testCase14() {
        //normalPeriod startTime is less than endTime
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase15() {
        //reducePeriod startTime is greater than endTime
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 8));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase16() {
        //normalPeriod startTime is greater than endTime
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(23, 21));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test
    public void testCase17() {
        //reducePeriod startTime is 0
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(0, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test
    public void testCase18() {
        //normalPeriod startTime is 0
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(0, 8));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test
    public void testCase19() {
        //reducePeriod startTime is greater than 0
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(1, 8));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test
    public void testCase20() {
        //normalPeriod startTime is greater than 0
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(1, 6));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase21() {
        //reducePeriod startTime is not a number
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period('&', 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase22() {
        //normalPeriod startTime is not a number
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period('c', 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase23() {
        //reducePeriod endTime is greater than 24
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(21, 26));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(18, 20));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase24() {
        //normalPeriod endTime is greater than 24
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(17, 20));
        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 26));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase25() {
        //reducePeriod is null
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();


        normalPeriods.add(new Period(13, 16));
        normalPeriods.add(new Period(21, 23));

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, null, normalPeriods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase26() {
        //normalPeriod is null
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();


        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, null);
   }


    @Test(expected = IllegalArgumentException.class)
    public void testCase27() {
//if a collection of periods is valid or overlap
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(3,4));
        reducedPeriods.add(new Period(4,5));
        reducedPeriods.add(new Period(4,5));
        reducedPeriods.add(new Period(4,5));
        reducedPeriods.add(new Period(4,5));


        new Rate(CarParkKind.STAFF, normalRate, reducedRate, normalPeriods, reducedPeriods);

    }

    @Test
    public void testCase28(){
        // test calculate rate VISITOR: first 8.00 is free
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(10,12));
        reducedPeriods.add(new Period(4,5));

        Rate total = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertEquals(total.calculate(new Period(10,12)),new BigDecimal("0.00"));

    }

    @Test
    public void testCase29(){
        // test calculate rate VISITOR: 50% discount after €8 on normal rate
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(0);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(10,16));
        reducedPeriods.add(new Period(17,18));

        Rate total = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertEquals(total.calculate(new Period(10,16)),new BigDecimal("8.00"));

    }

    @Test
    public void testCase30(){
        // test calculate rate VISITOR: 50% discount after €8 on reduce rate
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();

        normalPeriods.add(new Period(10,11));
        reducedPeriods.add(new Period(12,22));

        Rate total = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertEquals(total.calculate(new Period(12,22)),new BigDecimal("6.00"));

    }


}
