package com.tothenew.mongobasics

import com.tothenew.mongobasics.enums.ResultType
import grails.converters.JSON

class StudentController {

    def index() {
        redirect(action: 'listAll')
    }

    def listAll(){
        render Student.list() as JSON
    }

    def findAllByResultType(){
        ResultType resultType = params.resultType as ResultType
        render Student.withCriteria {
            eq('results.type', resultType)
        } as JSON
    }


    def findAllFirstGradeStudents(){
        render Student.withCriteria {
            eq('results.type', ResultType.EXAM)
            gt('results.score', 60 )
        } as JSON
    }

    def findAllFirstGradeStudentsUsingLowLevel(){
        List<Student> studentList = []
        Map query = [results: [ $elemMatch:[score: [$gt:60], "type":"EXAM"]]]
        def students = Student.collection.find(query)
        students?.each {
            Student student = new Student(it)
            student.id = it['_id']
            studentList << student
        }
        render studentList as JSON
    }



}
