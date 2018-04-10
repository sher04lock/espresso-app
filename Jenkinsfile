node() {

  try {
    def imageTag = "app-${env.BRANCH}:$BUILD_NUMBER" 

    stage('Checkout') {
      checkout scm
    }

    stage('Docker image build') {
      bat "docker build -t ${imageTag} ."
    }

    stage('App build') {
      bat "docker build -t ${imageTag} ."
      bat "docker run -it --rm -v ${PWD}:/application ${imageTag}"
    }
  }
  catch (err) {
    currentBuild.result = "FAILURE"
    throw err
  }
  finally {
        stage('Cleanup') {
            sh "docker rm -f ${imageTag}"
            sh "docker rmi ${imageTag}"
        }      
  }
}