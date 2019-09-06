

pipeline {
     agent any
     tools { // 
        jdk 'JDK11'
        export JAVA_HOME='/var/jenkins_home/tools/hudson.model.JDK/JDK11/jdk-11.0.1'
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