job('NodeJS example') {
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
        shell("npm install")
    }
}