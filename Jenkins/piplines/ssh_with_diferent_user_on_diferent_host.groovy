pipeline {
    agent any
    
    stages {
        stage('user john') {
            steps {
                script {
                    def remote = [:]
                    remote.user = 'john2'
                    remote.password = 'm@iLpA05061992'
                    remote.allowAnyHosts = true
                    remote.name = "192.168.1.14"
                    remote.host = "192.168.1.14"
                    
                    sshCommand remote: remote, command: "whoami"

                    echo "Sleeping for 5 seconds"
                    sleep time: 5, unit: 'SECONDS'
                }
            }
        }
        
        
        
        
        stage('user root') {
            steps {
                script {
                    def remote = [:]
                    remote.user = 'root'
                    remote.password = 'root'
                    remote.allowAnyHosts = true
                    remote.name = "192.168.1.14"
                    remote.host = "192.168.1.14"
                    
                    sshCommand remote: remote, command: "whoami"

                    echo "Sleeping for 5 seconds"
                    sleep time: 5, unit: 'SECONDS'
                }
            }
        }
        
        
    }
}
