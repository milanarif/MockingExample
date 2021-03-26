package calc;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
   int add(String inputString) {
      String delim = "[,|\n]";
      List<Integer> exceptionNumber = new ArrayList<>();
      if(inputString.length() == 0){
         return 0;
      }
      if(inputString.startsWith("//")){
         delim = StringUtils.substringBetween(inputString, "//", "\n");
         inputString = inputString.substring(inputString.indexOf("\n")+1);
      }
      int sum = Arrays.stream(inputString.split(delim))
              .mapToInt(Integer::parseInt)
              .peek(n -> {if (n < 0) exceptionNumber.add(n);})
              .filter(n -> n <= 1000)
              .sum ();
      if(exceptionNumber.isEmpty()){
         return sum;
      }
      else throw new IllegalArgumentException(StringUtils.join(exceptionNumber).replaceAll("[\\[\\]]",""));
   }
}
