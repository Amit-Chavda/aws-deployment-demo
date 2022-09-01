pipeline {
    agent any
    environment {
<<<<<<< HEAD
        remoteServer = "ec2-43-205-119-165.ap-south-1.compute.amazonaws.com"
=======
        remoteServer = "ec2-3-110-94-172.ap-south-1.compute.amazonaws.com"
>>>>>>> e23b847 (Changed aws instance dns name)

        fileName = "aws-deployment-demo-0.1.jar"
        /*
        print java version
        remove old file
        stop running app
        download new from S3 bucket
        run new downloaded file in background and exit */
        remoteCommands ="""java --version;
        rm -r deployments;
        sudo kill \$(sudo lsof -t -i:8085);
        aws s3 cp s3://aws-spring-deployment-bucket/aws-deployment-demo-0.1.jar deployments/ &&
        nohup java -jar deployments/aws-deployment-demo-0.1.jar >/dev/null 2>&1 &
        sleep 5"""
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