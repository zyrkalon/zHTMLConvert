#!/bin/sh

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
JARFILE="$SCRIPT_DIR/target/zHTMLConvert-1.0-SNAPSHOT.jar"

if [ $# -lt 2 ]; then
    INFILE="$SCRIPT_DIR/input.md"
    OUTFILE="$SCRIPT_DIR/output.html"
else
    INFILE="$1"
    OUTFILE="$2"
fi

if [ ! -f "$INFILE" ]; then
    echo "Usage: $(basename "$0") <input.md> <output.html>"
    echo "Press Enter to close this window..."
    read _ >/dev/null 2>&1
    exit 1
fi

if ! command -v java >/dev/null 2>&1; then
    echo "Error: Java not found. Please install Java 17+ and ensure it is in your PATH." >&2
    echo "Press Enter to close this window..."
    read _ >/dev/null 2>&1
    exit 1
fi

if [ ! -f "$JARFILE" ]; then
    echo "Error: JAR file not found at $JARFILE" >&2
    echo "Build the project first: mvn clean package" >&2
    echo "Press Enter to close this window..."
    read _ >/dev/null 2>&1
    exit 1
fi

java -jar "$JARFILE" "$INFILE" "$OUTFILE"
EXITCODE=$?

echo "Press Enter to close this window..."
read _ >/dev/null 2>&1

exit $EXITCODE
