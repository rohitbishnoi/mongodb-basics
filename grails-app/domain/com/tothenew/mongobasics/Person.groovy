package com.tothenew.mongobasics

import grails.rest.Resource

class Person {

    String firstName
    String lastName
    Integer age

    static constraints = {
        age nullable: true
    }

    static mapWith = "mongo"
}


/*
GET	    /books	            index
GET	    /books/create	    create
POST	/books	            save
GET	    /books/${id}	    show
GET	    /books/${id}/edit	edit
PUT	    /books/${id}	    update
DELETE	/books/${id}	    delete

*/