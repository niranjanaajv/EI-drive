public class MarkdownTextFormatter implements TextFormatter {
    @Override
    public String format(String text) {
        return "**" + text + "**";
    }
}
