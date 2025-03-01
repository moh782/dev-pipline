pipeline {
    agent any
    tools{
        maven 'maven_3_5_0'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/zinebdri/devops-automatisation.git']]])
                sh 'mvn clean install'
            
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t zineb932/devops-integration:latest .'
                }
            }
        }
          stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u zineb932 -p ${dockerhubpwd}'

}
                   sh 'docker push zineb932/devops-integration:latest'
                }
            }
        }
         stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8sconfigpwd')
                }
            }
        }
    }
} comme ca
