pipeline {
    agent any

    tools {
        maven 'Maven2'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'customer_branch', url: 'https://github.com/hrithik2023-21/Customer.git'
            }
        }

        stage('Build the Code') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Build Successful 🎉'
        }
        failure {
            echo 'Build Failed ❌'
        }
    }
}

