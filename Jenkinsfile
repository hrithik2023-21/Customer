pipeline {
	agent any
	tools {
		maven 'Maven3'
		jdk 'JDK'
	}
	environment {
		URL = 'https://github.com/hrithik2023-21/Customer.git'
		BRANCH_NAME = 'customer_branch'
		credentialsId: 'github-token'
	}
	options {
		buildDiscarder(logRotator(numToKeepStr: '10'))
		retry(2)
		disableConcurrentBuilds()
		timestamps()
	}
	
	stages {
		stage('compile the code') {
			steps {
				git branch: "&BRANCH_NAME", url: "&URL"
			}
		}
		stage('build the code') {
			steps {
				bat 'mvn clean package -DskipTests'
			}
		}
		stage ('run the test cases') {
			steps {
				bat 'mvn test'
			}
		}
	}
	post {
		success {
			echo 'Build successfully competed'
		}
		failure {
			echo 'Build failed'
		}
	}
}