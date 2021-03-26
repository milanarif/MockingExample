package calc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

   @Test
   void newLineSeparationTest(){
      String inputString = "1,2\n3,4";
      int expectedSum = 10;

      int actualSum = stringCalculator.add(inputString);

      assertThat(actualSum).isEqualTo(expectedSum);
   }

   @Test
   void optionalDelimiter(){
      String inputString = "//;\n1;2";
      int expectedSum = 3;

      int actualSum = stringCalculator.add(inputString);

      assertThat(actualSum).isEqualTo(expectedSum);
   }

   @Test
   void negativeThrowsException(){
      String inputString = "1,2,-3,2,-5";
      String expectedMessage = "negatives not allowed -3, -5";

      Exception exception = assertThrows(IllegalArgumentException.class, () ->
              stringCalculator.add(inputString));
      assertThat(exception.getMessage()).isEqualTo(expectedMessage);
   }

   @Test
   void valuesOver1000(){
      String inputString = "2,1001";
      int expectedSum = 2;

      int actualSum = stringCalculator.add(inputString);

      assertThat(actualSum).isEqualTo(expectedSum);
   }

   @Test
   void anyLengthDelimiter(){
      String inputString = "//[***]\n1***2***3";
      int expectedSum = 6;

      int actualSum = stringCalculator.add(inputString);

      assertThat(actualSum).isEqualTo(expectedSum);
   }
   @Test
   void multipleDelimiters(){
      String inputString = "//[*][%]\n1*2%3";
      int expectedSum = 6;

      int actualSum = stringCalculator.add(inputString);

      assertThat(actualSum).isEqualTo(expectedSum);
   }
}