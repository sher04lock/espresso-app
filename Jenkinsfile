node() {

    def imageTag = "espresso-app:$BUILD_NUMBER" 

  try {
    stage('Checkout') {
      checkout scm
    }

    stage('Docker image build') {
      try {
      bat "docker build -t ${imageTag} ."  // replace bat with sh for unix
      } catch (err) {
        "image build failed"
        currentBuild.result = "FAILURE"
      }
    }

    stage('App build') {
      try {
      bat "docker run -it --rm -v \"${WORKSPACE}\":/application ${imageTag}"
      } catch (err) {
        echo "app build failed"
        currentBuild.result = "FAILURE"
      }
    }
  }
  catch (err) {
    currentBuild.result = "FAILURE"
    throw err
  }
  finally {
        stage('Cleanup') {
            bat "docker rmi ${imageTag}"
        }      
  }
}