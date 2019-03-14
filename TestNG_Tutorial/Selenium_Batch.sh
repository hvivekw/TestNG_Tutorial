projectLocation="$PWD"
CLASSPATH="${projectLocation}/bin:${projectLocation}/lib/*"
chmod +x ${projectLocation}/lib/*.jar
chmod +x ${projectLocation}/bin
java -cp ${projectLocation}/bin:${projectLocation}/lib/* org.testng.TestNG ${projectLocation}/testng.xml
pause