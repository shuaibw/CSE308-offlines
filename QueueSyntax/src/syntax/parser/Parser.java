package syntax.parser;

public abstract class Parser {
    protected String name;

    public void activate() {
        System.out.println(name + " is activated");
    }
}
