package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
   public static long getCountOfFreeEmails(List<String> emails) {
       List<String> freeDomains = List.of("gmail.com", "yandex.ru", "hotmail.com");
       return emails.stream()
               .map(email -> email.split("@")[1])
               .filter(domain -> freeDomains.contains(domain))
               .count();
   }
}



// END
