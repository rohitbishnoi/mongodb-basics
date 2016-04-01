import com.tothenew.mongobasics.Person

class BootStrap {

    def init = { servletContext ->
        String[] firstNames = ['Alex', 'David', 'Peter', 'Tom', 'Shaun', 'Bill', 'Mary', 'Dan', 'Mark']
        String[] lastNames = ['Michaels', 'Peterson', 'Jackson', 'Jones', 'Hank', 'Cruise']
        Integer[] ages = (20..40).toArray()

        Person.list()*.delete(flush: true)

        10.times {
            new Person(firstName: getRandom(firstNames), lastName: getRandom(lastNames), age: getRandom(ages)).save()
        }

        assert Person.list().size() == 10

    }
    def destroy = {
    }

    static def getRandom(Object[] array) {
        array?.length ? array[(array.length * Math.random()).toInteger()] : null
    }
}
