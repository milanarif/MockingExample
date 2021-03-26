package calc;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
   int add(String inputString) {
      if(inputString.length() == 0){
         return 0;
      }
      inputString = handleCustomDelimiters(inputString);
      List<Integer> exceptionNumber = new ArrayList<>();

      int sum = Arrays.stream(inputString.split(","))
              .mapToInt(Integer::parseInt)
              .peek(n -> {if (n < 0) exceptionNumber.add(n);})
              .filter(n -> n <= 1000)
              .sum ();
      if(exceptionNumber.isEmpty()){
         return sum;
      }
      else
         throw new IllegalArgumentException("negatives not allowed " + StringUtils.join(exceptionNumber).replaceAll("[\\[\\]]",""));
   }

   private String handleCustomDelimiters(String s) {
      StringBuilder builder = new StringBuilder();
      boolean skip = false;
      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         if ((Character.isDigit(c)) || c == '-'){
            skip = true;
            builder.append(c);
         } else if (skip) {
            skip = false;
            builder.append(",");
         }
      }
      return builder.toString();
   }
}
