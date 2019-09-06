pipeline {
    jdk = tool name: 'JDK17'
    env.JAVA_HOME = "${jdk}"

    agent any
    stages {
        stage('Build') {
            steps {
                    sh "chmod +x gradlew"
                    sh "./gradlew clean build"
            }
        }
    }
}