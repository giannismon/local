pipeline {
    agent any

    stages {

        
        stage('Clean Workspace') {
            steps {
                // Καθαρισμός του workspace πριν από το επόμενο build
                deleteDir()
            }




        stage('Restart Server') {
            steps {
                script {
                    // Συνδέσου στον server και κάνε restart

                    sh 'hostname'
                    sh 'nohup sudo reboot now > /dev/null 2>&1 &'

                    // Περίμενε 20 λεπτά πριν συνεχίσεις
                    sh 'sleep 20'
                }
            }
        }

        stage('Check Server Status') {
            steps {
                script {
                    // Δοκίμασε να κάνεις ping στον server για να ελέγξεις αν έχει ξεκινήσει
                    sh 'uptime'
                }
            }
        }
    }
}
