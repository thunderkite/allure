@echo off
setlocal EnableDelayedExpansion
set MAVEN_VERSION=3.9.9
set MAVEN_ROOT=%USERPROFILE%\.m2\wrapper\apache-maven-%MAVEN_VERSION%
set MAVEN_BIN=%MAVEN_ROOT%\bin\mvn.cmd
if not exist "%MAVEN_BIN%" (
  set MAVEN_ZIP=%TEMP%\apache-maven-%MAVEN_VERSION%-bin.zip
  powershell -NoProfile -ExecutionPolicy Bypass -Command "Invoke-WebRequest -UseBasicParsing -Uri 'https://archive.apache.org/dist/maven/maven-3/%MAVEN_VERSION%/binaries/apache-maven-%MAVEN_VERSION%-bin.zip' -OutFile '!MAVEN_ZIP!'"
  if errorlevel 1 exit /b 1
  powershell -NoProfile -ExecutionPolicy Bypass -Command "New-Item -ItemType Directory -Force -Path '%USERPROFILE%\.m2\wrapper' | Out-Null; Expand-Archive -Path '!MAVEN_ZIP!' -DestinationPath '%USERPROFILE%\.m2\wrapper' -Force"
  if errorlevel 1 exit /b 1
)
call "%MAVEN_BIN%" %*