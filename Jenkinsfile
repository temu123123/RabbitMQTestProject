pipeline {
    agent any

    tools {
        gradle 'Gradle-Latest' 
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'gradle clean build -x test'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'gradle test'
            }
        }

        stage('Deploy (Mock)') {
            steps {
                echo 'Deploying application (Simulation)...'
                sh 'echo "Deploy successful!"'
            }
        }
    }
    
    post {
        always {
            junit testResults: 'build/test-results/test/*.xml', allowEmptyResults: true
        }
    }
}
