import com.tothenew.mongobasics.Person
import com.tothenew.mongobasics.Student
import com.tothenew.mongobasics.embedded.Result
import com.tothenew.mongobasics.enums.ResultType

class BootStrap {

    def init = { servletContext ->

        String[] firstNames = ['Alex', 'David', 'Peter', 'Tom', 'Shaun', 'Bill', 'Mary', 'Dan', 'Mark']
        String[] lastNames = ['Michaels', 'Peterson', 'Jackson', 'Jones', 'Hank', 'Cruise']
        Integer[] ages = (20..40).toArray()
        Long[] scores = (1..100).toArray()

        Person.collection.drop()
        Student.collection.drop()


        //created 10 Persons
        10.times {
            new Person(firstName: getRandom(firstNames), lastName: getRandom(lastNames), age: getRandom(ages)).save()
        }


        //created 10 Students
        10.times {
            Result result1 = new Result(score: getRandom(scores), type: getRandom(ResultType.values()))
            Result result2 = new Result(score: getRandom(scores), type: getRandom(ResultType.values()-result1.type))
            new Student(name: getRandom(firstNames), results: [result1, result2]).save()
        }

        assert Person.list().size() == 10
        assert Student.list().size() == 10
    }

    def destroy = {
    }

    static def getRandom(Object[] array) {
        array?.length ? array[(array.length * Math.random()).toInteger()] : null
    }
}
