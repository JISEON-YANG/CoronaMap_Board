pipeline {
    agent any
    stages {
        stage('Build gradle') {
            steps {
                sh './gradlew build'
            }
        }
        stage('test Who'){
            steps {
                sh 'who'
            }
        }
        stage('Build docker image') {
            steps {
                sh 'docker build -t mybox .'
            }
        }

        stage('login'){
            steps{
                sh 'aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 679117170907.dkr.ecr.ap-northeast-2.amazonaws.com'
            }
        }

        stage('tag'){
            steps{
                sh 'docker tag mybox:latest 679117170907.dkr.ecr.ap-northeast-2.amazonaws.com/mybox:0.1'
            }
        }

        stage('push'){
            steps{
                sh 'docker push 679117170907.dkr.ecr.ap-northeast-2.amazonaws.com/mybox:0.1'
            }
        }
    }
}