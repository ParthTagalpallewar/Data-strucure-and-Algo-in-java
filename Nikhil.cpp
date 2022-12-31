/*
 * name
 * roll_no
 * class
 * division
 * data_of_birth
 * blood_grounp
 * contact_address
 * telephone_number
 * driving_address_number
 *
 * */

/*
 *Constructor
 *Default Constructor
 *Copy Constructor
 *Destructor
 *Static Member function
 *Friend Class
 *This Pointer
 *In-line Code
 *Dynamic Memory Allocation
 *Exception handling
 *
 */

#include <iostream>
using namespace std;

class Database;
class Student
{
    string name;

public:
    friend class Database;
    void addStudent(string name)
    {
        this->name = name;
    }
};

class Database
{
private:
    Student stud[20];

public:
    void addStudent()
    {
        string name;
        cout << "Enter Name ";
        cin >> name;

        stud[0].addStudent(name);
    }

    void displayStudents()
    {
        cout << stud[0].name;
    }
};

int main()
{

    Database db;

    db.addStudent();
}
