OpenJFX internal docs

Starting an application

Main Thread:
An application is started via the main method, where javafx.application.Application.launch(Class, String…) is called.

This invokes
com.sun.javafx.application.LauncherImpl.launchApplication(appClass, args);

This will check if there is a preloader, and then call
com.sun.javafx.application.LauncherImpl.launchApplication(appClass, preloaderClass, args);

This will create a new Thread (named JavaFX-Launcher) in which it will invoke
launchApplication1(appClass, preloaderClass, args)

The original thread waits until that launchApplication1 returned.

LauncherThread 
(Thread-name = JavaFX-Launcher)
started in com.sun.javafx.application.LauncherImpl 
This will invoke a number of things:
* start toolkit

startToolkit: com.sun.javafx.application.LauncherImpl.startToolkit()
will invoke  PlatformImpl.startup(() -> startupLatch.countDown()).

This method will wait until startupLatch is released.

PlatformImpl.startup(Runnable r) does a number of things, including
Toolkit mt = Toolkit.getToolkit();
and
Toolkit.getToolkit().startup(() -> {
            startupLatch.countDown();
            r.run();
        });

The first part, Toolkit.getToolkit() will create an instance of the toolkit, which is unless otherwise specified QuantumToolkit and invoke the init method on it.
During clinit of QuantumToolkit, the <clinit> on PrismSettings is called as well.

QuantumToolkit.init() calls a number of things:
* create a renderer (e.g. Software, ES2,...)
* create a graphicsPipeline

The second part will start the toolkit:
Toolkit.getToolkit().startup

ok.

This will invoke a glass method:
com.sun.glass.ui.Application.run(() -> runToolkit());

The Application.run(Runnable launchable) method will first create an application (e.g. GtkApplication, MonocleApplication,...) and then invoke the runloop as follows:

           application.runLoop(() -> {
                Screen.initScreens();
                launchable.run();
            });

The implementations of application.runLoop() are expected to create the JavaFX Application thread. As a consequence, the runToolkit() runnable is executed on the new thread.

runToolkit will also create pulseTimer, and starts it, which will perdiodically invoke QuantumToolkit.this.postPulse();

