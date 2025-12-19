pipeline {
    agent any

    tools {
        gradle 'Gradle-Latest'
    }

    stages {
        stage('Build') {
            steps {
                echo '=== Building RabbitMQ Sender ==='
                dir('rabbitmq') {
                    sh 'gradle clean build -x test'
                }

                echo '=== Building RabbitMQ Receiver ==='
                dir('rabbitmq-reciever') {
                    sh 'gradle clean build -x test'
                }
            }
        }

        stage('Test') {
            steps {
                echo '=== Testing RabbitMQ Sender ==='
                dir('rabbitmq') {
                    sh 'gradle test'
                }

                echo '=== Testing RabbitMQ Receiver ==='
                dir('rabbitmq-reciever') {
                    sh 'gradle test'
                }
            }
        }

        stage('Deploy (Mock)') {
            steps {
                echo 'Deploying both applications (Simulation)...'
                sh 'echo "Deploy successful!"'
            }
        }
    }
    
    post {
        always {
            junit testResults: '**/build/test-results/test/*.xml', allowEmptyResults: true
        }
    }
}
