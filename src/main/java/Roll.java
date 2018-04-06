import java.io.IOException;

public class Roll {

    // Attributes
    private int value;

    // Constructor
    public Roll(){
        //this.value = (int)(Math.random()*10);
        this.value = (int)(Math.random()*10);
    }

    // Gets
    public int getValue(){
        // Shows normal random numbers
        return this.value;
    }

    public void setValue(){
        this.value = (int)(Math.random()*10);
    }
}
