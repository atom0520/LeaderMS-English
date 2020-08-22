@echo off
title Stop Server
color 5F
echo.
echo.

taskkill /im java.exe /f
taskkill /f /t /im mysqld-nt.exe
taskkill /f /t /im mysqld-debug.exe
taskkill /im cmd.exe /f

