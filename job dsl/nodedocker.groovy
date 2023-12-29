job('node js project ver 02'){
    description('this project will clone node js project from github repo and then build that project and then push code to docker hub repository')
    scm {
        git('https://github.com/hamzaProgrammer/temp-jenkins.git', "main") { node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('hamzaProgrammer')
            node / gitConfigEmail('hmaqsood295@gmail.com')
        }
    }
    wrappers {
        nodejs('Node 16')
        credentialsBinding{
            usernamePassword('hamza', 'hamza_78674' )
        }
    }
    steps{
        shell('npm install')
        shell('docker login -u hamza78674 -p hamza_78674')
        dockerBuildAndPublish {
            repositoryName('hamza78674/nodejs-jenkins-demo')
            tag('${BUILD_NUMBER}')
            //registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
        shell('docker logout')
    }
}