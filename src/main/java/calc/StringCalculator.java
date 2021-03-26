package calc;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {
   int add(String inputString) {
      String delim = "[,|\n]";
      if(inputString.length() == 0){
         return 0;
      }
      if(inputString.startsWith("//")){
         delim = StringUtils.substringBetween(inputString, "//", "\n");
         inputString = inputString.substring(inputString.indexOf("\n")+1);
      }
      return Arrays.stream(inputString.split(delim))
              .mapToInt(Integer::parseInt).sum ();
   }
}
