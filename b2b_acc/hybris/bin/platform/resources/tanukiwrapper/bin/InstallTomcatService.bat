@echo off
setlocal

set _YWRAPPER_CONF=%~dp0/../conf/wrapper.conf
call "%~dp0wrapper.bat" install

endlocal
