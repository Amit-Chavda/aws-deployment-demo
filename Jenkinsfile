pipeline {
  agent any
  triggers {
    pollSCM('*/1 * * * *')
  }
  options {
    buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5')
  }
  stages {
    stage('Clone and Checkout') {
      steps {
        git 'https://github.com/Amit-Chavda/aws-deployment-demo.git'
      }
    }
    stage('Install') {
      steps {
        bat "mvn install"
      }
    }
  }
}