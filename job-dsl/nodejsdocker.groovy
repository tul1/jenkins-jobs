job('NodeJS docker app') {
    scm {
        git('git://github.com/tul1/nodejs-app.git') {  node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('tula.patricio@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('/tul1/nodejs_app')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
