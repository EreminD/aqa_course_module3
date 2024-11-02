pipeline {
    agent {
        docker {
            image 'maven'
        }
    }
    stages {
        stage('Git') {
            steps {
                echo env.label

                echo 'chekout GIT'
                checkout scmGit(branches: [[name: env.branch]], extensions: [[$class: 'WipeWorkspace']], userRemoteConfigs: [[url: 'https://github.com/EreminD/aqa_course_module4']])
            }
        }
        stage('Validate'){
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test'){
            steps {
                sh 'mvn clean test \
                -Dtest=LabirintTest \
                -Dselenide.browserVersion=${version} \
                -Dselenide.browser=${browser} \
                -Dselenide.remote=${hub} \
                -Dselenide.baseUrl=${baseUrl} '
            }
        }
    }
    post {
        always {
            junit keepProperties: true, keepTestNames: true, stdioRetention: '', testResults: 'target/surefire-reports/TEST*.xml'
        }
    }
}
