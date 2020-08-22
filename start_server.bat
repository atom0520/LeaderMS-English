@echo off
# color y
cls


title Server Launcher
echo Set Java Path...
set JRE_HOME=jre
set JAVA_HOME=jre\bin
rem set path=%JAVA_HOME%\bin;%SystemRoot%\system32;%SystemRoot%;%SystemRoot%\System32\Wbem;
set path=jre\bin;%SystemRoot%\system32;%SystemRoot%;%SystemRoot%\System32\Wbem;
set CLASSPATH=jre\tools.jar;jre\dt.jar;.;dist\*;

echo Open Database...
rem set basedir=MySQL 
start /MIN MySQL\bin\mysqld-nt.exe --no-defaults --skip-bdb --skip-innodb --console --log=ms_log

start launch_world.bat

echo Loading World Server...


ping localhost -w 10000 >nul

ping localhost -w 10000 >nul


start launch_login.bat

echo Loading Login Server...

ping localhost -w 10000 >nul

ping localhost -w 10000 >nul


start launch_channel.bat

echo Loading Channel Server...

