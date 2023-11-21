pipeline {
    agent any

    stages {
        stage('Print Message') {
            steps {
                echo 'Hello, this is a simple Jenkins Pipeline!'
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
