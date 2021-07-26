pipeline {
    environment {
        registry = "679117170907.dkr.ecr.ap-northeast-2.amazonaws.com"
        registryCredential = 'ecr:ap-northeast-2:ecr-credentials'
    }
    agent any
    stages {
        stage('Environment') {
            parallel {
                stage('chmod') {
                    steps {
                        sh 'chmod 755 ./gradlew'
                    }
                }
                stage('display') {
                    steps {
                        sh 'ls -la'
                    }
                }
            }
        }
        stage('Build Jar') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Build docker image') {
            steps {
                sh 'docker build -t $registry:latest .'
            }
        }
        stage('Deploy docker image') {
            steps {
                 docker.withRegistry('679117170907.dkr.ecr.ap-northeast-2.amazonaws.com', 'ecr:ap-northeast-2:ecr-credentials') {
                     app.push("${env.BUILD_NUMBER}")
                     app.push("latest")
            }
        }
//         stage('Clean docker image') {
//             steps{
//                 sh "docker rmi $registry"
//             }
//         }
     }
}
}