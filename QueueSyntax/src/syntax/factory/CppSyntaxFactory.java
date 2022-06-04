package syntax.factory;

import syntax.font.Font;
import syntax.font.MonacoFont;
import syntax.parser.CppParser;
import syntax.parser.Parser;

public class CppSyntaxFactory extends AbstractSyntaxFactory{
    @Override
    public Parser getParser() {
        return new CppParser();
    }

    @Override
    public Font getFont() {
        return new MonacoFont();
    }
}
