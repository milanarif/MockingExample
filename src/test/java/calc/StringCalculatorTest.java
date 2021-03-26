package calc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

   @ParameterizedTest
   @MethodSource
   void sumOfUnknown(String input, int expected){
      assertThat(stringCalculator.add(input)).isEqualTo(expected);
   }

   private static Stream<Arguments> sumOfUnknown(){
      return Stream.of(
              arguments("1,2,3,4", 10),
              arguments("4,5,1,3,3,3", 19),
              arguments("4,4,4,5,5,5,6,6,6", 45)
      );
   }

}