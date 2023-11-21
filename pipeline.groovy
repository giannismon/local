pipeline {
    agent any

    stages {
        stage('Reboot and Check Server') {
            steps {
                // Βήμα 1: Επανεκκίνηση του server
                script {
                    sh 'nohup sudo shutdown -r &'
                    sleep(time: 10, unit: 'SECONDS')

                }
            }
        }

        stage('Wait for Server to Open') {
            steps {
                // Βήμα 2: Αναμονή για τον έλεγχο της διαθεσιμότητας του server
                script {
                    def waitTime = 30
                    echo "Waiting ${waitTime} seconds for the server to become available..."
                    sleep(waitTime)

                    def serverStatus = sh(script: 'ping -c 1 your_server_ip_or_hostname', returnStatus: true)

                    if (serverStatus == 0) {
                        echo 'Server is reachable. Proceeding with the next steps.'
                    } else {
                        error 'Server is not reachable. Pipeline will be marked as failed.'
                    }
                }
            }
        }

        stage('Additional Steps') {
            steps {
                // Βήμα 3: Εκτέλεση επιπλέον βημάτων αν ο έλεγχος είναι επιτυχής
                echo 'Additional steps after the server is reachable...'
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
