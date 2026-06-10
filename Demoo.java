// ===================================================================================
// 📝 THE COMPLETE STATIC KEYWORD COMPENDIUM (ALL RULES IN ONE FILE)
//
// 1. EXECUTION ORDER: When a program runs, Java executes things in this exact order:
//    👉 Static Blocks (Runs ONCE when class loads) 
//    👉 Main Method starts 
//    👉 Instance Initialization Blocks / Constructors (Runs every time 'new' is used)
//
// 2. THE GOLDEN RULES:
//    ✅ DO access static members using the Class Name (e.g., Mobile.name or Mobile.show1()).
//    ❌ DON'T try to use instance variables ('brand', 'price') inside a static method.
//    ❌ DON'T use the 'this' keyword inside static blocks or static methods.
// ===================================================================================

class Mobile {
    // 📦 HEAP MEMORY: Unique instance variables allocated per 'new Mobile()' object.
    String brand;
    int price;

    // 🌍 METHOD AREA MEMORY: A single shared slot belonging to the class template.
    static String name;

    // 🧱 STATIC INITIALIZATION BLOCK
    // Runs exactly ONCE when the class is first loaded into memory by the JVM.
    // Perfect for loading configurations or initializing complex static fields.
    static {
        name = "SmartPhone"; // Safely initialize our shared class variable
        System.out.println("🤖 [STATIC BLOCK] Mobile class loaded into memory. 'name' initialized to: " + name);
        // System.out.println(brand); // ❌ DON'T: This would crash the compiler! Can't see instance fields yet.
    }

    // 🏗️ CONSTRUCTOR
    // Runs every single time a new object instance is created via the 'new' keyword.
    public Mobile(String brand, int price) {
        this.brand = brand; // 'this' resolves variable shadowing between parameter and instance variable
        this.price = price;
        System.out.println("📦 [CONSTRUCTOR] New object created for brand: " + brand);
    }

    // 🟢 INSTANCE METHOD (DO)
    // Can freely access BOTH instance variables (brand, price) and static variables (name).
    public void show() {
        System.out.println("📱 [INSTANCE METHOD] Object Data -> " + brand + " : ₹" + price + " : Category: " + name);
    }

    // ⚙️ STATIC METHOD (DOs & DON'Ts)
    // Belongs directly to the class. Accessible without creating objects.
    public static void showStaticUtility() {
        System.out.println("⚙️ [STATIC METHOD] Global class action executed via Mobile.showStaticUtility()");
        System.out.println("Shared Variable Access -> Category: " + name); // ✅ DO: Read static variables safely
        
        // ❌ DON'T DO THIS:
        // System.out.println(brand); 
        // Crash Error: "non-static variable brand cannot be referenced from a static context"
        
        // ❌ DON'T DO THIS EITHER:
        // System.out.println(this.price); 
        // Crash Error: "cannot use keyword 'this' in a static context"
    }

    // 💡 THE STATIC BYPASS WORKAROUND
    // If a static method absolutely needs instance data, pass the object explicitly as an argument!
    public static void showWithExplicitObject(Mobile explicitObj) {
        System.out.println("💡 [STATIC BYPASS] Reading specific data -> Brand: " + explicitObj.brand + " | Shared Category: " + name);
    }
}

// Main execution container (Must match the file name Demoo.java)
public class Demoo {
    
    // 🚀 THE MAIN METHOD
    // Must be 'static' because the JVM needs to run it before any objects exist in memory!
    public static void main(String[] a) {
        System.out.println("🚀 [MAIN] Program execution started.");

        // 1. Call a static method directly via the Class Name (No object needed!)
        System.out.println("\n--- 1. Testing Class-Level Static Method ---");
        Mobile.showStaticUtility();

        // 2. Instantiate Object 1
        System.out.println("\n--- 2. Creating First Object ---");
        Mobile obj1 = new Mobile("Apple", 1500);
        obj1.show();

        // 3. Instantiate Object 2
        System.out.println("\n--- 3. Creating Second Object ---");
        Mobile obj2 = new Mobile("Samsung", 1700);
        obj2.show();

        // 4. Demonstrate Shared Nature of Static Variables
        System.out.println("\n--- 4. Changing Shared Static Variable ---");
        Mobile.name = "Legacy FeaturePhone"; // Updating the single global slot
        System.out.println("⚠️ Notice how the category changes for BOTH objects instantly:");
        obj1.show(); // Outputs "Legacy FeaturePhone"
        obj2.show(); // Outputs "Legacy FeaturePhone"

        // 5. Testing the Static Object Parameter Bypass Method
        System.out.println("\n--- 5. Testing Static Bypass Workaround ---");
        Mobile.showWithExplicitObject(obj1); // Explicitly pass obj1 so the static method can read its heap space
    }
}
