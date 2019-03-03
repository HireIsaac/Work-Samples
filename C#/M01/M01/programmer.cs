using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace M01
{
    class Programmer : Person
    {
        public override double computePayCheck()
        {
            return this.salary / 26;
        }

        public override double computePayRaise()
        {
            return this.performanceRating * 108;
        }

        public Programmer(string fname, string lname, string address, double salary, double perfRate) {
            this.firstName = fname;
            this.lastName = lname;
            this.address = address;
            this.salary = salary;
            this.performanceRating = perfRate;
        }
    }
}
