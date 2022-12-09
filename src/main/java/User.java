import java.io.Serializable;

public class User implements Serializable {
    private String name;

    @Override
    public String toString() {
        return "User{name=" + name +  "}";
    }

    void setName(String name){
        this.name = name;
    }


    String getName(){
        return name;
    }
}