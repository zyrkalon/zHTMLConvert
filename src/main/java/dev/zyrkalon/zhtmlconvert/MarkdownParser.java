package dev.zyrkalon.zhtmlconvert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownParser {

    private static final Pattern HEADING = Pattern.compile("^(#{1,3})\\s+(.+)$");
    private static final Pattern BOLD = Pattern.compile("\\*\\*(.+?)\\*\\*");

    public String parse(String markdown) {
        if (markdown == null || markdown.trim().isEmpty()) {
            return "";
        }

        String[] lines = markdown.split("\n", -1);
        StringBuilder html = new StringBuilder();
        StringBuilder paragraph = new StringBuilder();

        for (String line : lines) {
            String trimmed = line.trim();

            if (trimmed.isEmpty()) {
                flushParagraph(html, paragraph);
                continue;
            }

            Matcher headingMatcher = HEADING.matcher(trimmed);
            if (headingMatcher.matches()) {
                flushParagraph(html, paragraph);
                int level = headingMatcher.group(1).length();
                String content = processInline(headingMatcher.group(2));
                html.append("<h").append(level).append(">").append(content)
                    .append("</h").append(level).append(">\n");
                continue;
            }

            if (paragraph.length() > 0) {
                paragraph.append(" ");
            }
            paragraph.append(processInline(trimmed));
        }

        flushParagraph(html, paragraph);
        return html.toString();
    }

    private void flushParagraph(StringBuilder html, StringBuilder paragraph) {
        if (paragraph.length() > 0) {
            html.append("<p>").append(paragraph).append("</p>\n");
            paragraph.setLength(0);
        }
    }

    private String processInline(String text) {
        StringBuffer sb = new StringBuffer();
        Matcher m = BOLD.matcher(text);
        while (m.find()) {
            m.appendReplacement(sb, "<strong>$1</strong>");
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
