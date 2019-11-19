pipeline {
    environment {
        scannerHome = tool 'SonarQubeScanner-4.2.0'
    }

    agent {
        node {
            label 'master'
            // customWorkspace 'workspace/G5.c.feat/${env.BRANCH_NAME}'
        }
    }
    
    options{
        buildDiscarder(logRotator(numToKeepStr: '1'))
    }

    stages {
        stage('Sequentiel') {
            environment {
                FOR_SEQUENTIAL = "some-value"
            }
            stages{
                stage('Start - BRANCH_NAME') {
                    steps {
                        sh 'echo "start de pipeline with branch : ${BRANCH_NAME} ; Node : ${NODE_NAME} ; Tag : ${TAG_NAME}"'
                    }
                }
                stage('When - tag') {
                    when { tag "tmpBuild*" }
                    steps {
                        sh 'echo "Tag = ${TAG_NAME} OK'
                    }
                }
                stage('Build-job1') {
                    steps {
                        build job: 'job1'
                    }
                }
                stage('Sonar') {
                  steps {
                    withSonarQubeEnv('SonarQube') {
                      //sh '${scannerHome}/bin/sonar-scanner -Dsonar.branch.name=$BRANCH_NAME'
                      sh 'mvn sonar:sonar -Dsonar.branch.name=$BRANCH_NAME'
                    }
                  }
                }
            }
        }
    }
}