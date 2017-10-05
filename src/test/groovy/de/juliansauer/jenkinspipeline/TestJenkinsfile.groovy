package de.juliansauer.jenkinspipeline

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

class TestJenkinsfile extends BasePipelineTest {

    @Override
    @Before
    void setUp() throws Exception {
        super.setUp()
        helper.registerAllowedMethod("git", [String.class], { file ->
            return new File("C:/Users/jsauer/Documents/projects/JenkinsPipeline")
        })
    }

    @Test
    void testJenkinsFile() {
        println("Testing Jenkinsfile")
        def script = loadScript("src/main/java/de/juliansauer/jobs/Jenkinsfile.groovy")
        script.run()
        printCallStack()
    }

}
