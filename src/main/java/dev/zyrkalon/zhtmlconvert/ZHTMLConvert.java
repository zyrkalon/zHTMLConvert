package org.example.zhtmlconvert;

import java.io.*;

public class ZHTMLConvert {

    private static final String HTML_TEMPLATE = """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>%s</title>
        </head>
        <body>
        %s
        </body>
        </html>
        """;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java ZHTMLConvert <input.md> <output.html>");
            System.exit(1);
        }

        String inputPath = args[0];
        String outputPath = args[1];
        MarkdownParser parser = new MarkdownParser();

        try {
            String markdown = readFile(inputPath);
            String bodyContent = parser.parse(markdown);
            String title = extractTitle(inputPath);
            String html = String.format(HTML_TEMPLATE, title, bodyContent);
            writeFile(outputPath, html);
            System.out.println("Converted " + inputPath + " -> " + outputPath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    static String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    static void writeFile(String path, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
        }
    }

    private static String extractTitle(String inputPath) {
        String name = new java.io.File(inputPath).getName();
        int dot = name.lastIndexOf('.');
        return (dot > 0) ? name.substring(0, dot) : name;
    }
}
