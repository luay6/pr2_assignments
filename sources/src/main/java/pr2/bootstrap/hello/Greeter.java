package pr2.bootstrap.hello;

/**
 * Eine freundliche Klasse, die gerne Menschen begrüßt.
 */
public class Greeter {

    /**
     * Begrüßt die Person.
     *
     * @param name Name der Person, die begrüßt wird.
     */
    public void greet(String name) {
        System.out.printf("Hallo %s\n", name);
    }
}
