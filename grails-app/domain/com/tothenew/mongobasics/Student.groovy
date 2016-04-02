package com.tothenew.mongobasics

import com.tothenew.mongobasics.embedded.Result

class Student {

    String name
    List<Result> results

    static constraints = {
    }

    static mapWith = "mongo"

    static embedded = ['results']
}
