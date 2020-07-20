@ECHO OFF

java -jar "%~dp0../lib/cucumber-sandwich.jar" -r "Android Report" -f "%~dp0../target/androidOutput" -o "%~dp0../target/androidOutput/" -n

pause