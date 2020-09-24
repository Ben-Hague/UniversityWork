@echo off
:a
javac Vehicle.java
echo Vehicle Class Complied
javac TunnelTollCharge.java
echo Cost Class Compiled
javac TunnelTollChargeUserExt.java
echo Program Class Compiled
echo Executing Program Class
java TunnelTollChargeUserExt
pause
goto a