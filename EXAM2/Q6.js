class Course{
    constructor(title){
        this.title = title;
        this.students = [];
    }
    addStudent(student) {
        this.students.push(student);
    }
    displayStudents(){
        console.log(this.title);
        for(let i = 0; i < this.students.length; i++){
            console.log(this.students[i].name);
            console.log(this.students[i].gpa);
        }
    }
}





var a = new Course();
var b = new Course();

var sarah = new Student("sarah", 3);
var john = new Student("john", 4);
a.addStudent(sarah)
b.addStudent(john);

a.displayStudents();
b.displayStudents();

