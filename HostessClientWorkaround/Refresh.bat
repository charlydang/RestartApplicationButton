@ECHO OFF
taskkill /im HostessClient.exe /t /f
timeout 2
cd C:\Program Files (x86)\QSR Automations\ConnectSmart\HostessClient
start HostessClient.exe


