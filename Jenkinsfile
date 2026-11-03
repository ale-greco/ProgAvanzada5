pipeline {
    agent any

    tools {
        maven 'Maven 3.9'
        jdk 'JDK 17'
    }

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

    }

    post {
        success {
            echo '¡Pipeline ejecutado exitosamente! El paquete y la imagen Docker están listos.'
        }
        failure {
            echo 'El pipeline falló en alguna de las etapas.'
        }
    }
}
