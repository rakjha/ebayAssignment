@ECHO OFF

java -jar "%~dp0../lib/cucumber-sandwich.jar" -r "iOS Report" -f "%~dp0../target/iOSOutput" -o "%~dp0../target/iOSOutput/" -n

pause
