package calc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

   StringCalculator stringCalculator = new StringCalculator();

   @Test
   void sumOfTwoNumbers(){
      String inputString = "1,2";
      int expectedSum = 3;

      int actualSum = stringCalculator.add(inputString);

      assertThat(actualSum).isEqualTo(expectedSum);
   }
   @Test
   void sumOfOneNumber(){
      String inputString = "999";
      int expectedSum = 999;

      int actualSum = stringCalculator.add(inputString);

      assertThat(actualSum).isEqualTo(expectedSum);
   }
   @Test
   void sumOfNoNumber(){
      String inputString = "";
      int expectedSum = 0;

      int actualSum = stringCalculator.add(inputString);

      assertThat(actualSum).isEqualTo(expectedSum);
   }
}