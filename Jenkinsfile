

pipeline {
     agent any
     tools { // 
        jdk 'JDK11'
      }

    stages {
        stage('Build') {
            steps {
                    sh "sh echo $JAVA_HOME"
                    sh "chmod +x gradlew"
                    sh "./gradlew clean build"
            }
        }
    }
}