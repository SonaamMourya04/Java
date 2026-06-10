// Definition of the blueprint class
class Human { 
    // PRIVATE FIELDS: Data hiding/Encapsulation. 
    // These containers cannot be accessed directly from outside this class.
    private int age; 
    private String name; 

    // GETTER METHOD: Provides secure read-only access to the private variable 'age'
    public int getAge() { 
        return age; // Sends the integer value back to the code that called it
    } 

    // GETTER METHOD: Provides secure read-only access to the private variable 'name'
    public String getName() { 
        return name; // Sends the String value back to the code that called it
    } 

    // SETTER METHOD: Provides a secure way to update the private 'age' variable
    public void setAge(int age) { 
        // 'this.age' points directly to the INSTANCE VARIABLE belonging to the object.
        // The raw 'age' points to the LOCAL PARAMETER passed into the method brackets.
        // Using 'this' breaks the variable shadowing conflict so the compiler knows the difference.
        this.age = age; 
    } 

    // SETTER METHOD: Provides a secure way to update the private 'name' variable
    public void setName(String n) { 
        // No 'this' keyword is needed here because the parameter name 'n' 
        // is completely different from the instance variable name 'name'.
        name = n; 
    } 
} 

// Main execution class
public class Encapsulation { 
    public static void main(String a[]) { 
        // Instantiates a new Human object container in memory
        Human obj = new Human(); 
        
        // Modifies the object's internal data safely using public setter methods
        obj.setAge(30); 
        obj.setName("reddy"); 
        
        // Fetches the hidden data via getters and prints it to the terminal screen
        // Added a spacer string (" : ") to make the final output easy to read!
        System.out.println(obj.getName() + " : " + obj.getAge()); 
    } 
}
