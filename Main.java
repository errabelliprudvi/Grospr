package prudvi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Replace 'path/to/data.json' with the actual path to your JSON file
            File jsonFile = new File("C:\\Users\\Neeraja\\Desktop\\sample.json");

            // Use TypeReference to specify the target type
            SampleBasicCapabilityConfigurations configurations = objectMapper.readValue(jsonFile, SampleBasicCapabilityConfigurations.class);

            // Access the parsed data
            List<CapabilityConfiguration> capabilityConfigurations = configurations.getSampleBasicCapabilityConfigurations();

            for (CapabilityConfiguration config : capabilityConfigurations) {
                System.out.println("Product Name: " + config.getProductName());
                System.out.println("Some Condition: " + config.isSomeCondition());

                NestedDataContainer nestedDataContainer = config.getNestedDataContainer();
                if (nestedDataContainer != null) {
                    List<String> someString = nestedDataContainer.getSomeString();
                    System.out.println("Some Strings:");
                    for (String str : someString) {
                        System.out.println("  " + str);
                    }
                }

                System.out.println("-------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
