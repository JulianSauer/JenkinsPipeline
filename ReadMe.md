# Demo unit tests for Jenkins pipeline

## General
This is a demo project which consists of a normal Maven project with unit tests as well as a pipeline script for compiling and testing it on a Jenkins server. The unit tests also check the pipeline script by using a Groovy runtime and the [JenkinsUnitPipeline](https://github.com/jenkinsci/JenkinsPipelineUnit) framework. Furthermore this project supports syntax highlighting and auto completion for the Jenkins DSL within [IntelliJ IDEA](https://www.jetbrains.com/idea/) (See [Syntax highlighting/code completion](#Syntax-highlighting)).

## Execution
Requires Java 8, Groovy and Maven. It was tested with Groovy 2.4, Maven 3.3 and 3.5.

### Pipeline tests
The pipeline tests (as well as the other tests) can be executed using the Maven profile `Pipeline-Test` to prevent Jenkins from running the pipeline within itself. The Maven command is `mvn clean test -P Pipeline-Test`.
The test will execute the Groovy script found under *src/main/java/de/juliansauer/jobs* which currently clones this repo using git and afterwards compiles, tests and archives the created artifact which is simply a demo file (see below for more info). The git command is mocked within the test class and simply tries to ping the given URL which fails with an exception if a 404 is received.
![Pipeline Test](https://i.imgur.com/ammqOsy.png)

### Java demo project
Running `mvn clean compile` will compile and run the Java project which simply creates a file called *DemoFile.txt* containing the current time and date.

### Demo tests
The unit tests written in Java only test the demo project (not the pipeline) by checking if the file creation works correctly. It can be achieved by using `mvn clean test`.

## <a name="Syntax-highlighting"></a> Syntax highlighting/code completion
To get syntax highlighting and auto completion for the pipeline DSL from Jenkins the file *src/main/java/de/juliansauer/pipeline.gdsl* is used. It can be copied from the server by either going to `https://<Jenkins server>/job/<project>/job/<job>/pipeline-syntax/gdsl` or by clicking on the little arrow that appears when hovering with the mouse over a job in the Jenkins web UI and then on `Pipeline Syntax` -> `IntelliJ IDEA GDSL`.

To be recognized by IntelliJ the file has to be in the **<font style="color: rgb(62,134,160)">sources root</font>** folder which should be *src/main/java* by default. If that is not the case, right click on the folder and go to `Mark Directory as` -> `Sources Root`. You'll also need a Groovy SDK for this - if not already set up IntelliJ should ask you to specify it.
