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
                set +e
                cd ${WORKSPACE}/script && ls
                bash ping.sh
                true
               '''
            }
        }
        stage('Deploy') { 
            steps {
               echo "deploy"
                sh '''
                cd ${WORKSPACE}/script && ls
                bash ping2.sh
               '''
            }
        }
        stage('StageName1')
        {
    steps
    {
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
        {
            echo "Stage2"
            sh "exit 1"
            
        }
    }
}
stage('StageName2')
{
    steps
    {
        echo "Stage2"
    }
}
    }
}
