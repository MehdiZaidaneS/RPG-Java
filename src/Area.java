import java.util.ArrayList;

public class Area {
    String name, description;

//basic getter and setter for area class
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return  name + ". Description of the area: " + description;
    }

}
