import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class LegacyCalculatorTests {
   @Test
   public void empty() {
      // arrange
      var calculator = new LegacyCalculator();

      // act
      var result = calculator.calculate(new LinkedList<LocalDateTime>());

      // assert
      Assert.assertEquals(LocalDateTime.MIN, result.getStartTime());
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
}
