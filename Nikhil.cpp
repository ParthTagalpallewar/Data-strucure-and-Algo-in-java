#include <iostream>
#include <fstream>
#include <vector>
#define file "patients.txt"
using namespace std;

class Patient
{
public:
	double PatientID, cost;
	int age, days, rid;
	char Patname[20], ward[20];
	void getdata();
	void display();
	void view();
	void delete_patient();
};

void Patient::delete_patient()
{
	ofstream out(file, ios::out);

	cout << "all data deleted successfully";

	out.close();
}
void Patient::getdata()
{
	ofstream f1(file, ios::app);
	int num;
	cout << "How many records you want to insert: ";
	cin >> num;
	for (int i = 0; i < num; i++)
	{
		cout << "\n\t Enter Name of Patient: ";
		cin >> Patname;
		cout << "\n\t Enter Patient ID: ";
		cin >> PatientID;
		cout << "\n\t Enter Patient's Ward: ";
		cin >> ward;
		cout << "\n\t Enter Durations in days: ";
		cin >> days;
		cout << "\n\t Enter cost: ";
		cin >> cost;
		cout << "\n\t Enter age: ";
		cin >> age;
		f1 << Patname << "\n"
		   << PatientID << "\n"
		   << ward << "\n"
		   << days << "\n"
		   << cost << "\n"
		   << age << "\n";
		cout << "\n-----------------------------------------------";
		cout << "\nRecord Inserted Successfully!!";
	}
	f1.close();
}
void Patient::display()
{
	ifstream f11(file);
	cout << "-----------------------------------------------";
	cout << "\nEnter Patient ID You want to search: ";
	cin >> rid;

	do
	{
		f11 >> Patname;
		f11 >> PatientID;
		f11 >> ward;
		f11 >> days;
		f11 >> cost;
		f11 >> age;
	} while (rid != PatientID);

	cout << "\n\nDetails of Patient is shown below:-";
	cout << "\n\tPatient Name :- " << Patname;
	cout << "\n\tPatient ID :- " << PatientID;
	cout << "\n\tPatient's Ward :- " << ward;
	cout << "\n\tDuration in days :- " << days;
	cout << "\n\tcost :- " << cost;
	cout << "\n\tPatient's Age :- " << age;

	f11.close();
}
void Patient::view()
{
	ifstream f11(file);
		cout << "-----------------------------------------------";

		int rid = -1;

		string Patname = "";
		int PatientID = -2;
		string ward = "";
		string days = "";
		string cost = "";
		string age = "";

		cout << "View All Patients" << endl;

		do
		{
			f11 >> Patname;
			f11 >> PatientID;
			f11 >> ward;
			f11 >> days;
			f11 >> cost;
			f11 >> age;


			if(PatientID == rid) break;

			if(PatientID == -2){
				cout << " Patients Does not exits " << endl;
				break;
			}

			rid = PatientID;

			cout << "\n\nDetails of Patient is shown below:-";
			cout << "\n\tPatient Name :- " << Patname;
			cout << "\n\tPatient ID :- " << PatientID;
			cout << "\n\tPatient's Ward :- " << ward;
			cout << "\n\tDuration in days :- " << days;
			cout << "\n\tcost :- " << cost;
			cout << "\n\tPatient's Age :- " << age;

		} while (true);


		f11.close();
}

int main()
{

	Patient e1;
	int ch;
	int k = 0;
	do
	{
		cout << "\n-------------------------------------------------------";
		cout << "\n********* __Patient Record System__ *********\n";
		cout << "Select Following Options Shown";
		cout << "\n1 => Add New Record";
		cout << "\n2 => Search Patient";
		cout << "\n3 => View All Records";
		cout << "\n4 => Delete All Records";
		cout << "\n5 => Exit";
		cout << "\n-------------------------------------------------------";
		cout << "\nEnter Your Choice ";
		cin >> ch;
		switch (ch)
		{
		case 1:
			e1.getdata();
			break;
		case 2:
			e1.display();
			break;
		case 3:
			e1.view();
			break;
		case 4:
			e1.delete_patient();
			break;
		case 5:
			k = 1;
			break;

		default:
			cout << "Invalid Option !!";
			break;
		}
	} while (k != 1);
	return 0;
}
