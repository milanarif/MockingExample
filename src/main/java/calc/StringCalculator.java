package calc;

import java.util.Arrays;

public class StringCalculator {
   int add(String inputString) {
      if(inputString.length() == 0){
         return 0;
      }
      return Arrays.stream(inputString.split(","))
              .mapToInt(Integer::parseInt).sum ();
   }
}
