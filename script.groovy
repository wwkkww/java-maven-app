def buildApp() {
    echo "building the application..."
} 

def testApp() {
    echo "Testing the application..."
} 

def deployApp() {
    echo "Deploying the application..."
    echo "Deploying version ${params.VERSION}"
} 



return this
