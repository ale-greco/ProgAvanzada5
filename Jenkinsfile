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
        stage('Compilación y Pruebas Unitarias') {
            steps {
                sh 'mvn clean test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

         stage('Pruebas de Integración') {
            steps {
                sh 'mvn verify -DskipTests=false'
            }
        }

        stage('Empaquetado (Build JAR)') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Construcción de Imagen Docker') {
            steps {
                script {
                    sh 'docker build -t crud-personas:latest .'
                }
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
