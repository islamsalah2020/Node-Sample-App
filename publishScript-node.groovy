def PublishToNexus() {
        stage("Publish to Nexus Repository Manager") {
                    
                withCredentials([file(credentialsId: 'nexus-settings', variable: 'NEXUS_SETTINGS')]) {
                sh ' mvn deploy -s ${NEXUS_SETTINGS} '
                }   
        }
}


************************************************************
def PublishToNexus() {

    environment {
        registryCredentials = "nexus-creds"        
        registryPrivate = "https://qplatform.dev.qeema.io/nexus/repository/npm-repo/" // nexus repository
    }

    

        stage('Publish') {

            
                script {
                    
                        sh("rm ~/.npmrc || echo 'trying to remove .npmrc'") // remove .npmrc

                        // this token is copied from ~/.npmrc file after a interactive npm login
                        // do a npm login to your nexus npm hosted private repo and get the token
                        sh 'echo "//nexus:8081/repository/vinsystems-npm/:_authToken=NpmToken.302af6fb-9ad4-38cf-bb71-57133295c7ca" >> ~/.npmrc'

                        sh 'npm publish --registry=${registryPrivate} '

                        
                    
                }
            
        }
    
}

return this;
