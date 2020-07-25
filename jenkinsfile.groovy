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
                // 
            }
        }
        stage('Deploy') { 
            steps {
                // 
            }
        }
    }
}
