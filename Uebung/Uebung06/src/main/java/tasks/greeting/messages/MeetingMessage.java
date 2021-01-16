package tasks.greeting.messages;

import java.io.Serializable;

public class MeetingMessage implements Serializable {
    private static final long serialVersionUID= 1L;
    private final String greeting;

    public MeetingMessage (String greeting){
        this.greeting= greeting;
    }

    public String getGreeting(){
        return greeting;
    }

    @Override
    public String toString() {
        return "MeetingMessage{" +
                "greeting='" + greeting + '\'' +
                '}';
    }
}
