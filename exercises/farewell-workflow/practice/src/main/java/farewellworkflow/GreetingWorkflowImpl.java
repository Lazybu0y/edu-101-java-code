package farewellworkflow;

import java.time.Duration;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

public class GreetingWorkflowImpl implements GreetingWorkflow {

    ActivityOptions options = ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofSeconds(5))
        .build();

    private final GreetingActivities activities = Workflow.newActivityStub(GreetingActivities.class, options);

    @Override
    public String greetSomeone(String name){
        String spanishGreeting = activities.greetInSpanish(name);
        // TODO: uncomment the line below and change it to execute the Activity method you created
        String spanishFarewell = activities.farewellInSPanish(name);

        return "\n" + spanishGreeting + "\n" + spanishFarewell;
    }
}
