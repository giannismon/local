pipeline {
    agent any

    stages {
        stage('Restart Server') {
            steps {
                script {
                    // Συνδέσου στον server και κάνε restart
                    sh 'sudo reboot now'

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
