node {
    stage ('checkout') {
        git 'https://github.com/JulianSauer/JenkinsPipeline.git'
    }
    stage ('build') {
        sh 'mvn compile'
    }
    stage ('test') {
        sh 'mvn test'
    }
}
