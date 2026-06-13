# zHTMLConvert — Markdown to HTML Converter

A console-based Java application that converts Markdown files into clean, standalone HTML webpages instantly.

---

## Requirements

- **Java SE 17** or higher (tested up to JDK 25)
- **Maven** (only needed to build from source)

---

## Build

```bash
mvn clean package
```

This produces `target/zHTMLConvert-1.0-SNAPSHOT.jar`.

---

## Run

### Windows

**Using the wrapper script** (recommended — double-click or run from terminal):

```cmd
.\zhtmlconvert.cmd input.md output.html
```

**Directly with Java:**

```cmd
java -jar target\zHTMLConvert-1.0-SNAPSHOT.jar input.md output.html
```

### Linux / macOS

**Using the wrapper script:**

```bash
chmod +x zhtmlconvert.sh
./zhtmlconvert.sh input.md output.html
```

**Directly with Java:**

```bash
java -jar target/zHTMLConvert-1.0-SNAPSHOT.jar input.md output.html
```

---

## Parsing Matrix

| Markdown Element            | HTML Output                          | Processing Rule / Context                 |
|-----------------------------|--------------------------------------|-------------------------------------------|
| `# Heading 1`               | `<h1>Heading 1</h1>`                | Matches single `#` prefix at line start   |
| `## Heading 2`              | `<h2>Heading 2</h2>`                | Matches double `##` prefix at line start  |
| `### Heading 3`             | `<h3>Heading 3</h3>`                | Matches triple `###` prefix at line start |
| `**bold text**`             | `<strong>bold text</strong>`        | Inline replacement via Regex evaluations  |
| Regular unformatted text    | `<p>Regular unformatted text</p>`   | Blocks wrapped automatically              |

*Note: The converter wraps the entire translated body sequence inside a valid HTML5 structural template (`<!DOCTYPE html>`, `<html>`, `<head>`, and `<body>`).*

---

## Project Structure

```text
zHTMLConvert/
├── pom.xml                               # Maven project descriptor
├── README.md                             # This file
├── zhtmlconvert.cmd                      # Windows launcher
├── zhtmlconvert.sh                       # Linux/macOS launcher
└── src/main/java/dev/zyrkalon/
    ├── App.java                          # CLI arguments validation & execution lifecycle
    └── MarkdownParser.java               # File stream handles & structural Regex parsing rules
```

---

## Files Overview

- **`App.java`** — Main entry point. Validates input/output command-line arguments, triggers the document streaming cycles, and renders transformation logs to the terminal.
- **`MarkdownParser.java`** — Orchestrates the underlying conversion logic. Uses a `BufferedReader` to process strings line-by-line using Regex mappings, and compiles the final structure into the target destination using a `BufferedWriter`.
- **`zhtmlconvert.cmd`** — Windows batch wrapper that handles platform directory environments, checks for active local Java paths, and forwards arguments into the jar container.
- **`zhtmlconvert.sh`** — POSIX shell wrapper script for Linux/macOS systems that resolves global path dependencies and handles structural runtime execution.

---

## License

MIT
