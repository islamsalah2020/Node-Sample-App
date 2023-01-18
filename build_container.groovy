def buildImage() {
stage('Build Docker Image') {
                
            withCredentials([usernamePassword(credentialsId: 'gitlab-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh " echo $PASSWORD | docker login https://git.qeema.io:5050 -u $USERNAME --password-stdin "
                    sh "docker build -t ${REGISTRY}/${REPOSITORY}/${IMAGE}:${TAG} ."
                    sh "docker push ${REGISTRY}/${REPOSITORY}/${IMAGE}:${TAG}"
            }
}
}
return this;
