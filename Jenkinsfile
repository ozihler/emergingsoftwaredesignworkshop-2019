

pipeline {
     agent any
     tools { // this is the jdk specified in global configurations
        jdk 'JDK11'
      }

    stages {

        stage('Deploy') {
            steps {
                sh 'cd ${projectDir()}/backend/build/libs && java backend-0.1.0-SNAPSHOT.jar'
            }
        }
    }
}