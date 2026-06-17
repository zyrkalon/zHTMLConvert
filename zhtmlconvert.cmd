@echo off
setlocal enabledelayedexpansion

set "JARFILE=%~dp0target\zHTMLConvert-1.0-SNAPSHOT.jar"

if "%2"=="" (
    set "INFILE=%~dp0input.md"
    set "OUTFILE=%~dp0output.html"
) else (
    set "INFILE=%1"
    set "OUTFILE=%2"
)

if not exist "%INFILE%" (
    echo Usage: %~n0 ^<input.md^> ^<output.html^>
    pause
    exit /b 1
)

where java >nul 2>nul
if %ERRORLEVEL% neq 0 (
    echo Error: Java not found. Please install Java 17+ and ensure it is in your PATH.
    pause
    exit /b 1
)

if not exist "%JARFILE%" (
    echo Error: JAR file not found at %JARFILE%
    echo Build the project first: mvn clean package
    pause
    exit /b 1
)

java -jar "%JARFILE%" "%INFILE%" "%OUTFILE%"
set "EXITCODE=%ERRORLEVEL%"
pause
exit /b %EXITCODE%
