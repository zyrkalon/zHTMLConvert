package org.example.zhtmlconvert;

import java.util.regex.Pattern;

public class MarkdownParser {

    private static final Pattern HEADING = Pattern.compile("^(#{1,3})\\s+(.+)$");
    private static final Pattern BOLD = Pattern.compile("\\*\\*(.+?)\\*\\*");

    public String parse(String markdown) {
        if (markdown == null || markdown.isBlank()) {
            return "";
        }

        String[] lines = markdown.split("\n", -1);
        StringBuilder html = new StringBuilder();
        StringBuilder paragraph = new StringBuilder();

        for (String line : lines) {
            String trimmed = line.trim();

            if (trimmed.isBlank()) {
                flushParagraph(html, paragraph);
                continue;
            }

            var headingMatcher = HEADING.matcher(trimmed);
            if (headingMatcher.matches()) {
                flushParagraph(html, paragraph);
                int level = headingMatcher.group(1).length();
                String content = processInline(headingMatcher.group(2));
                html.append("<h").append(level).append(">").append(content)
                    .append("</h").append(level).append(">\n");
                continue;
            }

            if (!paragraph.isEmpty()) {
                paragraph.append(" ");
            }
            paragraph.append(processInline(trimmed));
        }

        flushParagraph(html, paragraph);
        return html.toString();
    }

    private void flushParagraph(StringBuilder html, StringBuilder paragraph) {
        if (!paragraph.isEmpty()) {
            html.append("<p>").append(paragraph).append("</p>\n");
            paragraph.setLength(0);
        }
    }

    private String processInline(String text) {
        return BOLD.matcher(text).replaceAll(m -> "<strong>" + m.group(1) + "</strong>");
    }
}
