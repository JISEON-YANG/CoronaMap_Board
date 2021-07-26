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
        }
        stage('aws login'){
            steps{
                sh 'aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 679117170907.dkr.ecr.ap-northeast-2.amazonaws.com'
            }
        }
        stage('docker build'){
            steps{
                sh 'docker build -t mybox .'
            }
        }
        stage('Make tag'){
            steps{
                sh 'docker tag mybox:latest 679117170907.dkr.ecr.ap-northeast-2.amazonaws.com/mybox:latest'
            }
        }
        stage('Push'){
            steps{
                sh 'docker push 679117170907.dkr.ecr.ap-northeast-2.amazonaws.com/mybox:latest'
            }
        }

    }
}