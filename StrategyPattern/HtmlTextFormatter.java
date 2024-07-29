public class HtmlTextFormatter implements TextFormatter {
    @Override
    public String format(String text) {
        return "<html><body>" + text + "</body></html>";
    }
}
