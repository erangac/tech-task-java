package com.macroactive.cal;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class LegacyCalculatorTests {

   @Test
   public void withEmptyDates() {
      // arrange
      var calculator = new LegacyCalculator();

      // act
      var result = calculator.calculate(new LinkedList<>());

      // assert
      Assert.assertEquals(LocalDateTime.MIN, result.getStartTime());
      Assert.assertEquals(0, result.getCount());
   }

   @Test
   public void withNullDates() {
      // arrange
      var calculator = new LegacyCalculator();

      // act
      var result = calculator.calculate(null);

      // assert
      Assert.assertEquals(LocalDateTime.MIN, result.getStartTime());
      Assert.assertEquals(0, result.getCount());
   }

   @Test
   public void withOneDate() {
      // arrange
      var calculator = new LegacyCalculator();
      var dates = new LinkedList<LocalDateTime>();
      dates.add(LocalDateTime.MIN);

      // act
      var result = calculator.calculate(dates);

      // assert
      Assert.assertEquals(LocalDateTime.MIN, result.getStartTime());
      Assert.assertEquals(0, result.getCount());
   }

   /**
    * Second week has more dates than first week
    */
   @Test
   public void withManyDatesScenario01() {
      // arrange
      var calculator = new LegacyCalculator();
      var dates = new LinkedList<LocalDateTime>();
      dates.add(LocalDateTime.of(2018, 1, 1, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 2, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 10, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 11, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 12, 0, 0, 0));

      // act
      var result = calculator.calculate(dates);

      // assert
      Assert.assertEquals(LocalDateTime.of(2018, 1, 8, 0, 0, 0), result.getStartTime());
      Assert.assertEquals(3, result.getCount());
   }

   /**
    * Both first & second week has equal dates count. First day of the week is not countable.
    */
   @Test
   public void withManyDatesScenario02() {
      // arrange
      var calculator = new LegacyCalculator();
      var dates = new LinkedList<LocalDateTime>();
      dates.add(LocalDateTime.of(2018, 1, 1, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 2, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 3, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 8, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 10, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 11, 0, 0, 0));

      // act
      var result = calculator.calculate(dates);

      // assert
      Assert.assertEquals(LocalDateTime.MIN, result.getStartTime());
      Assert.assertEquals(0, result.getCount());
   }

   /**
    * First day of the week is not countable.
    */
   @Test
   public void withManyDatesScenario03() {
      // arrange
      var calculator = new LegacyCalculator();
      var dates = new LinkedList<LocalDateTime>();
      dates.add(LocalDateTime.of(2018, 1, 1, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 10, 0, 0, 0));

      // act
      var result = calculator.calculate(dates);

      // assert
      Assert.assertEquals(LocalDateTime.of(2018, 1, 8, 0, 0, 0), result.getStartTime());
      Assert.assertEquals(1, result.getCount());
   }

   /**
    * Dates out of two weeks range is not matters
    */
   @Test
   public void withManyDatesScenario04() {
      // arrange
      var calculator = new LegacyCalculator();
      var dates = new LinkedList<LocalDateTime>();
      dates.add(LocalDateTime.of(2018, 1, 1, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 10, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 17, 0, 0, 0));
      dates.add(LocalDateTime.of(2018, 1, 18, 0, 0, 0));

      // act
      var result = calculator.calculate(dates);

      // assert
      Assert.assertEquals(LocalDateTime.of(2018, 1, 8, 0, 0, 0), result.getStartTime());
      Assert.assertEquals(1, result.getCount());
   }


}
