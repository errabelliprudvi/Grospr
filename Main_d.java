import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_d {
    public static void main(String[] args) {
      ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Replace 'path/to/data.json' with the actual path to your JSON file
          //  File jsonFile = new File("C:\\Users\\Neeraja\\Desktop\\sample.json");
          

          
        String jsonString = "{\n" +
                "  \"sampleBasicCapabilityConfigurations\": [\n" +
                "    {\n" +
                "      \"productName\": \"bitbucket\",\n" +
                "      \"someCondition\": false,\n" +
                "      \"nestedDataContainer\": {\n" +
                "        \"someStrings\": [\n" +
                "          \"Bitbucket\",\n" +
                "          \"is\",\n" +
                "          \"awesome\"\n" +
                "        ]\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"productName\": \"confluence\",\n" +
                "      \"someCondition\": false,\n" +
                "      \"nestedDataContainer\": {\n" +
                "        \"someStrings\": [\n" +
                "          \"Confluence\",\n" +
                "          \"is\",\n" +
                "          \"the\",\n" +
                "          \"best\"\n" +
                "        ]\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"productName\": \"trello\",\n" +
                "      \"someCondition\": true,\n" +
                "      \"nestedDataContainer\": {\n" +
                "        \"someStrings\": [\n" +
                "          \"Trello\",\n" +
                "          \"is\",\n" +
                "          \"the\",\n" +
                "          \"greatest\",\n" +
                "          \"thing\",\n" +
                "          \"ever\"\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";




             // Read the JSON file into a string
           // String jsonString = new String(Files.readAllBytes(Paths.get("sample.json")));


            // Use TypeReference to specify the target type
            SampleBasicCapabilityConfigurations configurations = objectMapper.readValue(jsonString, SampleBasicCapabilityConfigurations.class);

            // Access the parsed data
            List<CapabilityConfiguration> capabilityConfigurations = configurations.getSampleBasicCapabilityConfigurations();

            for (CapabilityConfiguration config : capabilityConfigurations) {
                System.out.println("Product Name: " + config.getProductName());
                System.out.println("Some Condition: " + config.isSomeCondition());

                NestedDataContainer nestedDataContainer = config.getNestedDataContainer();
                if (nestedDataContainer != null) {
                    List<String> someStrings = nestedDataContainer.getSomeStrings();
                    System.out.println("Some Strings:");
                    for (String str : someStrings) {
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
