job('Node example') {
    scm('') { node ->
        node / gitConfigName('DSL User')
        node / gitConfigEmail('patricio.tula@gmail.com')
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