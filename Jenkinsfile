

pipeline {
     tools {
        jdk 'JDK_11.0.1'
     }

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