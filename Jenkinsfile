pipeline {
    agent any

    stages {
        stage('Prepare') {
            agent any

            steps {
                checkout scm
            }

            post {

                success {
                    echo 'prepare success'
                }

                always {
                    echo 'done prepare'
                }

                cleanup {
                    echo 'after all other post conditions'
                }
            }
        }

        stage('build gradle') {
            steps {
                sh  './gradlew build'


                sh 'ls -al ./build'
            }
            post {
                success {
                    echo 'gradle build success'
                }

                failure {
                    echo 'gradle build failed'
                }
            }
        }
        stage('docker build'){
            steps{
                app = docker.build("679117170907.dkr.ecr.ap-northeast-2.amazonaws.com/mybox")
            }
        }
        stage('push image'){
            steps{
                docker.withRegistry('679117170907.dkr.ecr.ap-northeast-2.amazonaws.com', 'ecr:ap-northeast-2:ecr-credentials') {
                     app.push("${env.BUILD_NUMBER}")
                     app.push("latest")
                }
            }
        }
    }
}