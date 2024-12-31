pipeline {
    agent any

    tools {
        maven 'sonar-maven'
    }

    environment {
         MAVEN_HOME="C:\\Users\\sheik\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9\\bin" 
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
                set PATH=%MAVEN_HOME%;%PATH%
                mvn clean
                '''
            }
        }

        stage('Test') {
            steps {
                echo 'Testing the project...'
                bat '''
                set PATH=%MAVEN_HOME%;%PATH%
                mvn test
                '''
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the compiled code...'
                bat '''
                set PATH=%MAVEN_HOME%;%PATH%
                mvn package
                '''
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Running SonarQube analysis...'
                bat '''
                set PATH=%MAVEN_HOME%;%PATH%
                mvn sonar:sonar ^
                -Dsonar.projectKey=Task2GPT ^
                -Dsonar.sources=src/main/java ^
                -Dsonar.tests=src/test/java ^
                -Dsonar.java.binaries=target/classes ^
                -Dsonar.projectName='Task2(GPT)' ^
                -Dsonar.host.url=http://localhost:9000 ^
                -Dsonar.token=sqp_802153cb2f5647f8e3c0c98c72dbaf3d8442c517
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
