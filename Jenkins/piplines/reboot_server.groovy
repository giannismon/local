pipeline {
    agent any

    stages {
        stage('PATH') {
            steps {
                script {


                    // Χρησιμοποιήστε την εντολή mkdir για τη δημιουργία του φακέλου
                    sh "hostname"
                    sh "pwd"
                    sh "mkdir path_folder"
                }
            }
        }

        // Εδώ μπορείτε να προσθέσετε άλλα stages για διάφορες διεργασίες
    }
}
