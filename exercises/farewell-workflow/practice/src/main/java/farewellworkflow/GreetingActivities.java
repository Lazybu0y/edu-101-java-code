package farewellworkflow;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface GreetingActivities {
    @ActivityMethod
    String greetInSpanish(String name);
   
    
    /* TODO: Define a method signature for a method that will get a farewell
     * message in Spanish. You can name your method whatever you like, but remember
     * the name as you'll need to implement it in a later step.
    */
     @ActivityMethod
    String farewellInSPanish(String name);
}
