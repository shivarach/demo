node {
	stage('code checkout') {
		tool name: 'mvn-3.6.1', type: 'maven'
		git https://github.com/shivarach/demo.git
	}
  stage('compile package') {
    sh 'mvn package'
  }
}
