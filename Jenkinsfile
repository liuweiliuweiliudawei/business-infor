pipeline {
    agent any

    stages {
        stage('pull code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '52993cec-f146-4ec8-ae19-1d7245da7d3a', url: 'git@github.com:liuweiliuweiliudawei/business-infor.git']]])
            }
        }
        stage('build project') {
            steps {
               sh '''cd /var/lib/jenkins/workspace/web_demo_pipeline/business-code/
mvn clean package
'''
            }
        }
    }
}
