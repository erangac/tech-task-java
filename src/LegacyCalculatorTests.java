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
}
