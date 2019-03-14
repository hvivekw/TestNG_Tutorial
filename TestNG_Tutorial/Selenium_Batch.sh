chmod -R 777 ./
projectLocation="$PWD"
CLASSPATH="${projectLocation}/bin:${projectLocation}/lib/*"
java -cp ${projectLocation}/bin:${projectLocation}/lib/* org.testng.TestNG ${projectLocation}/testng.xml
pause