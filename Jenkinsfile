pipeline {
	agent any
	tools {
		maven 'Maven3'
		jdk 'JDK'
	}
	environment {
		GIT_REPO_URL = 'https://github.com/hrithik2023-21/Customer.git'
	}
	options {
		buildDiscarder(logRotator(numToKeepStr: '10'))
		retry(2)
		disableConcurrentBuilds()
		timestamps()
	}
	parameters {
		string(name: 'BRANCH_NAME', defaultValue: 'customer_branch', description: 'git branch')
		choice(name: 'BUILD_ENV', choices: ['DEV', 'QA','PRODUCTION'], description: 'build environment')
		booleanParam(name: 'SKIP_TESTS', defaultValue: true, description: 'skipping the test cases')
	}
	
	stages {
		stage('compile the code') {
			steps {
				git branch: "${params.BRANCH_NAME}", url: "${GIT_REPO_URL}", credentialsId: 'github-token'
			}
		}
		stage('build the code') {
			steps {
				bat "mvn clean package ${params.SKIP_TESTS ? '-DskipTests': ''}"
			}
		}
		stage('print the environment') {
			steps {
				echo "deploying into ${params.BUILD_ENV} environment"
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