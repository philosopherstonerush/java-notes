import java.util.Optional;

class Main {
    public static void main(String[] args) {
        String nameNull = null;
        String name = "John Doe";

        // Replaces the text that I sent to the function.
        System.out.println(String.format("hi this is %s", Optional.ofNullable(name).orElse("User")));

        // Replaces it with User if null is sent.
        System.out.println(String.format("hi this is %s", Optional.ofNullable(nameNull).orElse("User")));
    }
}