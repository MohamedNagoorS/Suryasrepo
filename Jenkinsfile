pipeline {
    agent any

    tools {
        maven 'sonarmaven'
    }

    environment {
        MAVEN_PATH = 'C:\\Users\\surya\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9\\bin'
        SONAR_TOKEN = credentials('sonarqube-token')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean target folder') {
            steps {
                echo 'Cleaning target directory...'
                bat '''
                set PATH=%MAVEN_PATH%;%PATH%
                mvn clean
                '''
            }
        }

        stage('Test') {
            steps {
                echo 'Testing the project...'
                bat '''
                set PATH=%MAVEN_PATH%;%PATH%
                mvn test
                '''
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the compiled code...'
                bat '''
                set PATH=%MAVEN_PATH%;%PATH%
                mvn package
                '''
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Running SonarQube analysis...'
                bat '''
                set PATH=%MAVEN_PATH%;%PATH%
                mvn sonar:sonar ^
                  -Dsonar.projectKey=SQ-Assessment2 ^
                  -Dsonar.sources=src/main/java ^
                  -Dsonar.tests=src/test/java ^
                  -Dsonar.java.binaries=target/classes ^
                  -Dsonar.host.url=http://localhost:9000 ^
                  -Dsonar.token=%SONAR_TOKEN% ^
                  -Dsonar.duplications.hashtable=200000 ^
                  -Dsonar.duplications=always
                '''
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check logs for details.'
        }
    }
}
