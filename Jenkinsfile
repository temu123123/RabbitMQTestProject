pipeline {
    agent any

    tools {
        gradle 'Gradle-Latest' 
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'chmod +x gradlew'
                sh './gradlew clean build -x test'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh './gradlew test'
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
            junit 'build/test-results/test/*.xml'
        }
    }
}
