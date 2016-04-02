package com.tothenew.mongobasics.embedded

import com.tothenew.mongobasics.enums.ResultType
import grails.validation.Validateable

@Validateable
class Result {
    Long score
    ResultType type

    static constraints = {

    }


    static transients = ['errors']

}
