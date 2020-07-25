pipeline {
         agent any
         stages {
                 stage('Checking SCM folder') {
                       steps {
                           echo 'Hi, GeekFlare. Starting to build the App.'
                           sh '''
                           rm -rf *
                           '''
                       }
                 }
                 stage('Test') {
                       steps {
                          input('Do you want to proceed?')
                       }
                 }
                 stage('Deploy') {
                 
                 stage('Prod') {
                       steps {
                                  echo "App is Prod Ready"
                                }

              }
}
}
