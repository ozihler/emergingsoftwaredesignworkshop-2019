

pipeline {
     agent any
     tools { // this is the jdk specified in global configurations
        jdk 'JDK11'
      }

    stages {
        stage('Clean') {
            steps {
                sh "chmod +x gradlew"
                     sh "./gradlew clean"
            }
        }
        stage('Build') {
            steps {
                     sh "./gradlew build"
            }
        }
        stage('Test') {
            steps {
                     sh "./gradlew check"
            }
        }
        stage("Check code quality and coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                step([
                    $class : 'JacocoPublisher',
                    sourcePattern: '**/src/main/java, **/src/test/java',
                    classPattern: '**/build/classes',
                    exclusionPattern: '**/*Test.class',
                    execPattern: '**/build/jacoco/*.exec'
                ])
            }
        }
    }
}