package com.gluonhq.promise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloText extends Application {
    private final static int UTC = 2; // fix

    @Override
    public void start(Stage stage) {
        Label l = new Label("HELLOTEXT");
        StackPane sp = new StackPane(l);
        Scene scene = new Scene(sp, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
System.out.println("Hello, JavaFX! In Main");
String osname = System.getProperty("os.name");
String vendor = System.getProperty("java.vendor");
System.setProperty("java.vendor","bck2brwsr");
String vendor2 = System.getProperty("java.vendor", "none");
boolean vendor3 = System.getProperty("java.vendor", "none").equalsIgnoreCase("bck2brwsr");
System.out.println("[HelloFX main] osname = " + osname+" and vendor = " + vendor+" and vendor2 = " + vendor2+" and vendor 3 = " + vendor3);
System.setProperty("prism.order", "es2");
System.setProperty("prism.debug", "true");
System.setProperty("prism.verbose", "true");
System.setProperty("javafx.verbose", "true");
System.setProperty("glass.platform", "Web");
System.setProperty("glass.disableThreadChecks", "true");
System.setProperty("quantum.debug", "true");
com.gluonhq.webscheduler.Util.warmup();
        launch(HelloText.class, "");
    }

}
