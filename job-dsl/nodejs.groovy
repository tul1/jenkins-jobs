job('Node example') {
    scm('https://github.com/tul1/jenkins-jobs.git') { node ->
        node / gitConfigName('DSL User')
        node / gitConfigEmail('tula.patricio@gmail.com')
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
}