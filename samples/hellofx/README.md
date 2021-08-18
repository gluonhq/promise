First run the sample on desktop:

`mvn clean javafx:run`

Next, compile the code into javascript:
`mvn install bck2brwsr:aot`

This may take a few minutes to complete. The javascript files are generated based on the openjfx jar files. In the future, we will bundle the transpiled javascript files so that only the application specific code will need to be transpiled.

Open target/index.html from your browser

As an example, the contents of what should be in target are also available at http://download2.gluonhq.com/uongl/helloweb/target/index.html
