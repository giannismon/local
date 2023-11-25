pipeline {
    agent any

    stages {
        stage('Reboot Server') {
            steps {
                script {
                    // Εκτελούμε την εντολή reboot με sudo και τον χρήστη root
                    sh 'sudo -S <<< "root_password" reboot'
                    
                    // Περιμένουμε 1 λεπτό (60 δευτερόλεπτα)
                    sleep 60
                }
            }
        }
        
        stage('Check Server Status') {
            steps {
                script {
                    // Εδώ μπορείτε να προσθέσετε εντολές για να ελέγξετε την κατάσταση του server
                    // π.χ., να προσπαθήσετε να συνδεθείτε ξανά, να ελέγξετε το uptime, κλπ.
                    // Το παράδειγμα χρησιμοποιεί έναν υποθετικό έλεγχο του uptime.
                    sh 'uptime'
                }
            }
        }
    }
}
