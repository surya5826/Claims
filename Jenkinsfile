node {
stage("Git Clone"){

git branch: 'main', url: 'https://github.com/surya5826/Claims.git'
}
stage("Docker build"){ 
 sh 'docker build -t claims:latest .'
sh 'docker images'
stage("Deploy"){
 sh 'docker rm -f cliams||true' 
sh ' docker run -d -p 9000:9000 --name claims claims:latest'
}
}
}
