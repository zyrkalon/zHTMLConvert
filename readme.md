```markdown
# zHTMLConvert 🚀

**zHTMLConvert** lets you turn Markdown files into clean HTML webpages instantly.

Built with pure Java, this lightweight Command Line Interface (CLI) utility reads basic Markdown syntax (`#` headings, `**bold text**`, and paragraphs) and structures it into a fully valid, standards-compliant HTML5 document.

---

## ✨ Features

- **Instant Conversion:** Parses Markdown elements instantly into structured HTML tags.
- **Heading Support:** Converts `#`, `##`, and `###` to `<h1>`, `<h2>`, and `<h3>`.
- **Inline Styling:** Detects and changes `**bold text**` into `<strong>bold text</strong>`.
- **Smart Paragraphs:** Automatically wraps regular, block text into structural `<p>` tags.
- **Full Boilerplate Output:** Wraps content inside a proper HTML template (`<!DOCTYPE html>`, `<html>`, `<head>`, `<body>`).
- **Zero Dependencies:** Runs natively on standard Java SE without needing massive external libraries.

---

## 🛠️ How It Works

`zHTMLConvert` processes raw text streams dynamically line-by-line using Java File I/O and regular expressions (Regex) to map Markdown patterns to corresponding semantic HTML tags.


```

```
   [ Input.md ]
        │
        ▼

```

┌───────────────────────┐
│     zHTMLConvert      │
│  ───────────────────  │
│  1. BufferedReader    │  <-- Streams text efficiently line-by-line
│  2. Regex Engines     │  <-- Matches and replaces text tokens
│  3. BufferedWriter    │  <-- Assembles structural HTML elements
└───────────────────────┘
│
▼
[ Output.html ]

```

---

## ⚙️ Prerequisites

- **Java Development Kit (JDK):** Version 8 or higher installed on your local machine.
- **Terminal / Command Prompt:** To run the utility compilation and execution commands.

---

## 🚀 Quick Start Guide

Follow these simple steps to compile and run **zHTMLConvert** locally.

### 1. Clone & Setup
Save your main Java code file as `ZHTMLConvert.java` in an organized workspace directory.

### 2. Compile the Source Code
Open your terminal inside the directory containing the file and compile the Java program:
```bash
javac ZHTMLConvert.java

```

### 3. Run the Converter

Execute the compiled bytecode by passing the paths for your input Markdown file and desired output HTML file as arguments:

```bash
java ZHTMLConvert input.md output.html

```

---

## 📝 Parsing Example

### Input (`input.md`)

```markdown
# Getting Started with zHTMLConvert

This is a paragraph featuring **bold syntax** to emphasize important details.

## Next Steps
Stay tuned for future markdown features!

```

### Output (`output.html`)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Converted Document</title>
</head>
<body>
    <h1>Getting Started with zHTMLConvert</h1>
    <p>This is a paragraph featuring <strong>bold syntax</strong> to emphasize important details.</p>
    <h2>Next Steps</h2>
    <p>Stay tuned for future markdown features!</p>
</body>
</html>

```

---

## 🧠 Core Concepts Learned

By building or analyzing this repository, you gain exposure to core software engineering foundations:

1. **Java File I/O (`java.io`):** Utilizing `BufferedReader` and `BufferedWriter` to handle continuous file reading/writing streams safely without blocking system memory.
2. **Regular Expressions (`java.util.regex`):** Employing explicit `Pattern` and `Matcher` abstractions to identify formatting flags within continuous strings.
3. **Exception Handling:** Managing runtime file errors and invalid pathways cleanly with explicit `try-catch` safety blocks.

---

## 🗺️ Future Roadmap

Planned structural features for upcoming iterations:

* [ ] Support for italics (`*text*` or `_text_`)
* [ ] Ordered and unordered bulleted lists (`-` or `1.`)
* [ ] Hyperlinks (`[Text](URL)`) and image embeds (`![Alt](URL)`)
* [ ] Custom CSS theme styling embedding (`--style` flag support)

```

```