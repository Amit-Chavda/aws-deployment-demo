pipeline {
    agent any
    environment {
        remoteServer = "ec2-43-205-119-165.ap-south-1.compute.amazonaws.com"

        fileName = "aws-deployment-demo-0.1.jar"
        /*
        print java version
        stop running app
        remove old copy
        download new from S3 bucket
        run new downloaded file */
        remoteCommands ="""java --version;
        sudo kill \$(sudo lsof -t -i:8085);
        rm -r deployments;
        aws s3 cp s3://aws-spring-deployment-bucket/$fileName deployments/;
        nohup java -jar /deployments/$fileName & exit"""
    }
    stages {
      /*   stage('Clone and Checkout') {
            steps {
                git 'https://github.com/Amit-Chavda/aws-deployment-demo.git'
            }
        } */
        stage('Installing...') {
            steps {
                bat "mvn install"
            }
        }
        stage("Uploading...") {
            steps {
                withAWS(credentials: 'aws-creds', region: 'ap-south-1') {
                    sh 'aws s3 cp target/*.jar s3://aws-spring-deployment-bucket'
                }
            }
        }
        stage('Deploying...') {
            steps {
                withAWS(credentials: 'aws-creds', region: 'ap-south-1') {
                    sshagent(['ubnt-creds']) {
                        sh "ssh -o StrictHostKeyChecking=no -tt ubuntu@$remoteServer '$remoteCommands'"
                    }
                }
            }
        }
    }
}