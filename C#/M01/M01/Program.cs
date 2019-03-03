using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace M01
{
    class Program
    {
        static void Main(string[] args)
        {
            
            

            Programmer p = new Programmer("Zach", "Higgs", "123 sesame street",26,0.0001 );
            Manager m = new Manager("Nick", "Sullivan", "1234 sesame street",100000,0.1);
            Average a = new Average("Erich", "Genoootter", "12345 sesame street", 50000, 0.1);

            ArrayList employees = new ArrayList();
            employees.Add(p); 
            employees.Add(m);
            employees.Add(a);

            foreach (Person emp in employees) {
                Console.WriteLine("Information for: " + emp.firstName + " " + emp.lastName + ". Paycheck: " + emp.computePayCheck() 
                    + "$ Pay raise: " + emp.computePayRaise() + " Address: " + emp.address );
                Console.WriteLine();
            }
            
            Console.ReadKey();

        }
    }
}
