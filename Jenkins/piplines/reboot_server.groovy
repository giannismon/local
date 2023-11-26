pipeline {
    agent any

    stages {
        stage('Create Folder') {
            steps {
                script {
                    // Ορίστε τον όνομα του φακέλου που θέλετε να δημιουργήσετε
                    def folderName = 'my_folder'

                    // Χρησιμοποιήστε την εντολή mkdir για τη δημιουργία του φακέλου
                    sh "mkdir -p ${folderName}"
                }
            }
        }

        // Εδώ μπορείτε να προσθέσετε άλλα stages για διάφορες διεργασίες
    }
}
