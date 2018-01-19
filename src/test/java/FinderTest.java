import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FinderTest {

    @org.junit.Test
    public void fileContainsFB() throws IOException {

        Finder finder = new Finder();

        assertEquals(new ArrayList<String>(Arrays.asList("c.d.FooBar", "a.b.FooBarBaz")), finder.fileContainsClass("classes.txt", "FB"));
    }

    @org.junit.Test
    public void fileContainsFoBa() throws IOException {

        Finder finder = new Finder();

        assertEquals(new ArrayList<String>(Arrays.asList("c.d.FooBar", "a.b.FooBarBaz")), finder.fileContainsClass("classes.txt", "FoBa"));
    }

    @org.junit.Test
    public void fileContainsFBar() throws IOException {

        Finder finder = new Finder();

        assertEquals(new ArrayList<String>(Arrays.asList("c.d.FooBar", "a.b.FooBarBaz")), finder.fileContainsClass("classes.txt", "FBar"));
    }

    @org.junit.Test
    public void fileNotContainsBF() throws IOException {

        Finder finder = new Finder();

        assertNotEquals(new ArrayList<String>(Collections.singletonList("c.d.FooBar")), finder.fileContainsClass("classes.txt", "BF"));
    }

    @org.junit.Test
    public void fileContainsfbb() throws IOException {

        Finder finder = new Finder();

        assertEquals(new ArrayList<String>(Collections.singletonList("a.b.FooBarBaz")), finder.fileContainsClass("classes.txt", "fbb"));
    }

    @org.junit.Test
    public void fileNotContainsfBb() throws IOException {

        Finder finder = new Finder();

        assertNotEquals(new ArrayList<String>(Collections.singletonList("a.b.FooBarBaz")), finder.fileContainsClass("classes.txt", "fBb"));
    }

    @org.junit.Test
    public void fileContainsFBar_() throws IOException {

        Finder finder = new Finder();

        assertEquals(new ArrayList<String>(Collections.singletonList("c.d.FooBar")), finder.fileContainsClass("classes.txt", "FBar "));
    }

    @org.junit.Test
    public void fileNotContainsFBarBaz_() throws IOException {

        Finder finder = new Finder();

        assertNotEquals(new ArrayList<String>(Collections.singletonList("a.b.FooBarBaz")), finder.fileContainsClass("classes.txt", "FBar "));
    }

    @org.junit.Test
    public void fileContainsWWC() throws IOException {

        Finder finder = new Finder();

        assertEquals(new ArrayList<String>(Collections.singletonList("a.b.FooBarBaz")), finder.fileContainsClass("classes.txt", "B*rBaz"));
    }

    @org.junit.Test
    public void fileNotContainsBrBaz() throws IOException {

        Finder finder = new Finder();

        assertNotEquals(new ArrayList<String>(Collections.singletonList("a.b.FooBarBaz")), finder.fileContainsClass("classes.txt", "BrBaz"));
    }

}