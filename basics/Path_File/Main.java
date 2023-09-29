
import java.nio.file.Path;
import java.nio.file.Paths;


class Main {
    public static void main(String[] args) {
        Path example = Paths.get("hi.txt");
        System.out.println(example.toAbsolutePath());
    }
}