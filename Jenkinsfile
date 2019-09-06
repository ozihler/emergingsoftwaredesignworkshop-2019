

pipeline {
     tools {
        jdk 'JDK11'
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