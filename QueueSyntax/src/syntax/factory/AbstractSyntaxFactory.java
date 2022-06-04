package syntax.factory;

import syntax.font.Font;
import syntax.parser.Parser;

public abstract class AbstractSyntaxFactory {
    public abstract Parser getParser();

    public abstract Font getFont();

    public static AbstractSyntaxFactory getFactory(String fileName) {
        String[] parts = fileName.split("\\.");
        String ext = parts[parts.length - 1];
        if (ext.equalsIgnoreCase("c")) {
            return new CSyntaxFactory();
        } else if (ext.equalsIgnoreCase("cpp")) {
            return new CppSyntaxFactory();
        } else if (ext.equalsIgnoreCase("py")) {
            return new PySyntaxFactory();
        } else {
            return null;
        }
    }
}
