pipeline {
    agent any

    environment {
        APP_PORT = "8080"
        JAR_NAME = "sasp-auth-1.jar"
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Stop Old App') {
            steps {
                bat '''
                echo Checking if app is running on port %APP_PORT%

                for /F "tokens=5" %%a in ('netstat -ano ^| findstr :%APP_PORT% ^| findstr LISTENING') do (
                    echo Killing process %%a
                    taskkill /PID %%a /F
                )

                echo Stop step completed
                '''
            }
        }

        stage('Start App') {
            steps {
                bat 'java -jar target/sasp-auth-1.jar'
            }
        }
    }

    post {
        success {
            echo "Build & deployment successful"
        }
        failure {
            echo "Build or deployment failed"
        }
    }
}
