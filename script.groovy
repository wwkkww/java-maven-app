def buildApp() {
    echo "building the application..."
}

def buildJar() {
    echo "building the app"
    sh 'mvn package'
}

def buildImage() {
    echo "building docker image"
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credential', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
      sh 'docker build -t wwkkww/java-maven-app:jma-2.0 .'
      sh "echo $PASS | docker login -u $USER --password-stdin"
      sh 'docker push wwkkww/java-maven-app:jma-2.0'
    }
} 

def testApp() {
    echo "Testing the application..."
} 

def deployApp() {
    echo "Deploying the application..."
    // echo "Deploying version ${params.VERSION}"
} 



return this
