pipeline {
    agent any 
    stages {
        stage('Checking repo') { 
            steps {
                echo "1234"
                sh '''
                rm -rf * 
                '''
            }
        }
        stage('Test') { 
            steps {
                 echo "Test clone file"
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false,
                          extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: '/script']]]],
                          submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/hoangpt2991/test.git']]])
                sh '''
                cd ${WORKSPACE}/script && ls
               '''
            }
        }
        stage('Deploy') { 
            steps {
               echo "deploy"
            }
        }
    }
}
