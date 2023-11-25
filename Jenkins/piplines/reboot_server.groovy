pipeline {
    agent any

    environment {
        // Ορίστε τη διεύθυνση του Git repository
        GIT_REPO_URL = 'https://github.com/giannismon/local.git'
    }

    stages {
        stage('Clone Repository') {
            steps {
                // Κάνε clone το Git repository
                script {
                    sh "git clone ${GIT_REPO_URL}"
                }
            }
        }

        // Εδώ μπορείτε να προσθέσετε επιπλέον stages για το build, το deploy, κλπ.
    }
}
