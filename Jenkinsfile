
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/bank-payment-api.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build & Push') {
            steps {
                sh '''
                    docker build -t bank-payment-api:latest .
                    docker tag bank-payment-api:latest <your-dockerhub-username>/bank-payment-api:latest
                    docker push <your-dockerhub-username>/bank-payment-api:latest
                '''
            }
        }
        stage('Deploy to QA') {
            steps {
                sh 'kubectl apply -f k8s/'
            }
        }
    }
}
