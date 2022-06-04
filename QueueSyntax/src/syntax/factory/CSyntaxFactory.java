package syntax.factory;

import syntax.font.CourierNewFont;
import syntax.font.Font;
import syntax.parser.CParser;
import syntax.parser.Parser;

public class CSyntaxFactory extends AbstractSyntaxFactory {

    @Override
    public Parser getParser() {
        return new CParser();
    }

    @Override
    public Font getFont() {
        return new CourierNewFont();
    }
}
