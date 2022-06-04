package syntax.singleton;

import syntax.factory.AbstractSyntaxFactory;
import syntax.font.Font;
import syntax.parser.Parser;

public class Editor {
    private static Editor editor;

    private Editor() {
    }

    public static synchronized Editor getInstance() {
        if (editor == null) {
            editor = new Editor();
        }
        return editor;
    }

    public void openFile(String filename) {
        AbstractSyntaxFactory asf = AbstractSyntaxFactory.getFactory(filename);
        if (asf == null) {
            System.out.println("Illegal file format");
            return;
        }
        Font font = asf.getFont();
        Parser parser = asf.getParser();
        font.activate();
        parser.activate();
    }
}
