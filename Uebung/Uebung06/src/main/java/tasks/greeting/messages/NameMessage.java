package tasks.greeting.messages;

import java.io.Serializable;

public final class NameMessage implements Serializable {
    private final static long serialVersionUID= 1L;
    private final String name;
    private final String surname;
    public NameMessage (String name, String surname){
        this.name= name;
        this.surname= surname;
    }
    public String getFirstName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }

    public static long getSerialVersionUID(){
        return serialVersionUID;
    }

    public String getFullName(){
        return surname + name;
    }

    @Override
    public String toString() {
        return "NameMessage{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
