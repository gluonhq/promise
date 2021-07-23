First run the sample on desktop:

`mvn clean javafx:run`

Next, compile the code into javascript:
`mvn install bck2brwsr:aot`

(this assumes the JavaFX jars are on a path specified by aotpath)

```
cp src/main/resources/index.html target
cp src/main/resources/uongl.js target
```

copy the index.html from resources to target. 

Open target/index.html from your browser
