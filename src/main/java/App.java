import java.util.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class App {

        public static void main(String[] args)
        {
            // Create a map to ArrayList values.
            ListMultimap<String, String> modules = ArrayListMultimap.create();

            // Add pairs to ListMultimap.
            modules.put("CS", "3219");
            modules.put("CS", "4218");
            modules.put("MA", "1101R");
            modules.put("MA", "1100");
            modules.put("IS", "1103");

            // Get list at this key.
            List<String> csModules = modules.get("CS");
            for (String code : csModules) {
                System.out.println("CS" + code);
            }
        }
}