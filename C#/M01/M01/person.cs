using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace M01
{
    public abstract class Person
    {
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string address { get; set; }
        public double salary { get; set; }
        public double performanceRating { get; set; }

        public abstract double computePayCheck();
        public abstract double computePayRaise();
    }
}
