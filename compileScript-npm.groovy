def CompileCode() {

         stage('Prepare') {
            sh ' echo "generic compile pipeline started" '
            
         }
  
         stage('Compile') {
                      
                     sh 'npm install'         
         }               
}

return this;

