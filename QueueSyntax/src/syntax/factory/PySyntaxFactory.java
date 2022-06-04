package syntax.factory;

import syntax.font.ConsolasFont;
import syntax.font.Font;
import syntax.parser.Parser;
import syntax.parser.PyParser;

public class PySyntaxFactory extends AbstractSyntaxFactory{
    @Override
    public Parser getParser() {
        return new PyParser();
    }

    @Override
    public Font getFont() {
        return new ConsolasFont();
    }
}
