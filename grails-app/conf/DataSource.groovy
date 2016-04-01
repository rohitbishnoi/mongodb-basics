grails {
    mongo {
        options {
            autoConnectRetry = true
            connectTimeout = 3000
            connectionsPerHost = 150
            socketTimeout = 60000
            threadsAllowedToBlockForConnectionMultiplier = 5
            maxAutoConnectRetryTime = 5
            maxWaitTime = 120000
        }
        host = "myvirtualmachine"
        port = 27017
        databaseName = "mongodb-intellimeet"
    }
}

environments {
    test {
        grails.mongo.databaseName = 'mongodb-intellimeet-test'
    }
}