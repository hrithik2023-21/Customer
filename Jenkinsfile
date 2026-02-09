pipeline {
	agent {label 'ubuntu'}
	tools {
		maven 'Maven3'
		jdk 'JDK'
		git 'GitUbuntu'
	}
	environment {
		GIT_REPO_URL = 'https://github.com/hrithik2023-21/Customer.git'
		BRANCH_NAME = 'customer_branch'
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
				git branch: "${BRANCH_NAME}", url: "${GIT_REPO_URL}", credentialsId: 'github-token'
			}
		}
		stage('build the code') {
			steps {
				sh 'mvn clean package -DskipTests'
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