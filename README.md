# promise

This repository discusses the steps required to run a JavaFX application
inside a browser.

It contains a sample `hellofx` which *should* work out of the box.
You can clone this repository, and cd into `samples/hellofx` and follow the
`README` there.

The remainder of this repository is targeting developers who want to 
contribute to JavaFX on the Web.
A number of steps are required to achieve this, and while the goal is
to automate all these steps and integrate them into Gluon Substrate, we
want developers to experiment with the components and show the current state.

## Warning
These instructions are for contributors or the brave developers who want
to combine different worlds (JavaFX, AOT, WebGL). They are by no means a
tutorial or how-to guide.

## Components

A number of components are required:

* bck2brwsr
* openjfx
* uongl

## bck2brwsr

Master repo: https://github.com/jtulach/bck2brwsr

We are working on getting all required changes upstream without reducing the 
quality of upstream. For now, the develop branch in https://github.com/johanvos/bck2brwsr can be used. It has a few diffs with upstream that we are looking on how to deal with.

Build with
`mvn install`

This will install the bck2brwsr jars in your local maven repository.

## OpenJFX

Master repo: https://github.com/openjdk/jfx

The required changes for Web deployement are in the promise branch in https://github.com/johanvos/jfx

Build with
`gradlew sdk`

This will build the jars and put them in `build/sdk/lib` .

The `resources` directory of this repository contains a snapshot of those jars in case you don't want to build them yourself.

Those jars are tagged and deployed to the Gluon Nexus repository.
For example, the tag t0813181438 corresponds to the version 18-internal+0-2021-08-13-181438 which is used in the pom.xml

## UONGL

Master repo: https://github.com/gluonhq/uongl

This is Gluon's WebGL implementation for the JavaFX rendering pipeline.
It contains a jar dealing with JavaFX specific threading issues, and
a javascript file (`uongl.js`) which implements the native JavaFX methods
leveraging WebGL. A snapshot of this javascript file is in the `resources`
directory of this repository.
The jar file is in maven central.

## Running the HelloFX sample

This is in the `samples/hellofx` directory.
Replace
`    <aotpath>PATH/TO/JAVAFX_LIBS</aotpath>`

with the path where the JavaFX libs are, either the ones you built yourself, or the ones in the resources/javafx dir of this project.

Replace `    <aotpath.compat>PATH/TO/COMPAT_JARS</aotpath.compat>` with the
path where the compat jars are.

Build with

`mvn install bck2brwsr:aot`

Copy `index.html` and `uongl.js` to the target directory.
Open a browser and move to that page.


