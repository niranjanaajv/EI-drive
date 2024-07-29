public class StrategyPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(new PlainTextFormatter());
        editor.publishText("Hello, World!");  // Hello, World!

        editor.setFormatter(new HtmlTextFormatter());
        editor.publishText("Hello, World!");  // <html><body>Hello, World!</body></html>

        editor.setFormatter(new MarkdownTextFormatter());
        editor.publishText("Hello, World!");  // **Hello, World!**
    }
}
