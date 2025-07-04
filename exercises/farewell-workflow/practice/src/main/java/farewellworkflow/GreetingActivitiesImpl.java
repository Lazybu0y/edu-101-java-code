package farewellworkflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import io.temporal.activity.Activity;

public class GreetingActivitiesImpl implements GreetingActivities {

    @Override
    public String greetInSpanish(String name) {
        return callService("get-spanish-greeting", name);
    }

    @Override
    public String farewellInSPanish(String name) {
        return callService("get-spanish-farewell", name);
    }

    /* TODO: Implement the Activity method that was defined in the
     * GreetingActivities interface. This method should call the microservice 
     * to get a farewell message in Spanish. It will be identical to the
     * method above, except that the first argument to the callService
     * method will be "get-spanish-farewell". The name of method needs to 
     * be the same as in the GreetingActivities interface
     */
    String callService(String stem, String name) {

        StringBuilder builder = new StringBuilder();

        String baseUrl = "http://localhost:9999/%s?name=%s";

        URL url = null;
        try {
            String urlString = String.format(baseUrl, stem, URLEncoder.encode(name, "UTF-8"));
            url = new java.net.URI(urlString).toURL();
        } catch (Exception e) {
            throw Activity.wrap(e);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw Activity.wrap(e);
        }

        return builder.toString();
    }
}
