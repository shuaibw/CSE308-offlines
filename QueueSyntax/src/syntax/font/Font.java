package syntax.font;

public abstract class Font {
    protected String name;
    public void activate(){
        System.out.println("Using font: " + name);
    }
}
