import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Finder finder = new Finder();

        String file = args[0];
        String pattern = args[1];

        System.out.println(finder.fileContainsClass(file, pattern));
    }
}
