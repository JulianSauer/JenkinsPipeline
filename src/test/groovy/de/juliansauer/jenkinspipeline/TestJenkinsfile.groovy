package de.juliansauer.jenkinspipeline

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

class TestJenkinsfile extends BasePipelineTest {

    @Override
    @Before
    void setUp() throws Exception {
        super.setUp()
        helper.registerAllowedMethod("git", [String.class], { scm ->
            pingUrl(scm)
        })
    }

    @Test
    void testJenkinsFile() {
        println("Testing Jenkinsfile:")
        def script = loadScript("src/main/java/de/juliansauer/jobs/Jenkinsfile.groovy")
        printCallStack()
    }

    static void pingUrl(String urlString) {
        URL url = new URL(urlString)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod("GET")
        connection.connect()
        String info = "Response code to " + urlString + " is " + connection.getResponseCode()
        if (connection.getResponseCode() == 404)
            throw new IOException(info)
        else
            println("   " + info)
    }

}
