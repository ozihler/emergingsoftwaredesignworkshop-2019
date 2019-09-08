

pipeline {
     agent any
     tools { // this is the jdk specified in global configurations
        jdk 'JDK11'
      }

    stages {

        stage('Deploy') {
            steps {
                sh '/var/jenkins_home/workspace/emerging-software-design-workshop/backend/build/libs/ && java backend-0.1.0-SNAPSHOT.jar'
            }
        }
    }
}