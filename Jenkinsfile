pipeline {

    agent {
        label 'jenkins'
    }
    stages {
        stage('Build') {
            steps {
                    sh "chmod +x gradlew"
                    sh "./gradlew clean build"
            }
        }
    }
}