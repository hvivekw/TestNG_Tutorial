set projectLocation=%pwd%
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
echo %classpath%
java org.testng.TestNG %projectLocation%\testng.xml
pause