using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace M02
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private ArrayList hairArr = new ArrayList();
        private ArrayList eyesArr = new ArrayList();
        private ArrayList noseArr = new ArrayList();
        private ArrayList mouthArr = new ArrayList();

        private BitmapImage hair1 = new BitmapImage(new Uri("hair1.png", UriKind.Relative));
        private BitmapImage hair2 = new BitmapImage(new Uri("hair2.png", UriKind.Relative));
        private BitmapImage eyes1 = new BitmapImage(new Uri("eyes1.png", UriKind.Relative));
        private BitmapImage eyes2 = new BitmapImage(new Uri("eyes2.png", UriKind.Relative));
        private BitmapImage nose1 = new BitmapImage(new Uri("nose1.png", UriKind.Relative));
        private BitmapImage nose2 = new BitmapImage(new Uri("nose2.png", UriKind.Relative));
        private BitmapImage mouth1 = new BitmapImage(new Uri("mouth1.png", UriKind.Relative));
        private BitmapImage mouth2 = new BitmapImage(new Uri("mouth2.png", UriKind.Relative));

        public MainWindow()
        {
            InitializeComponent();
            hairArr.Add(hair1);
            hairArr.Add(hair2);
            eyesArr.Add(eyes1);
            eyesArr.Add(eyes2);
            noseArr.Add(nose1);
            noseArr.Add(nose2);
            mouthArr.Add(mouth1);
            mouthArr.Add(mouth2);
            
        }

        

        

        private void updatePNG(BitmapImage i,  double y)
        {
            Image tempImg = new Image();
            tempImg.Source = i;
            tempImg.Width = i.Width;
            tempImg.Height = i.Height;

            Canvas.SetLeft(tempImg, 0);
            Canvas.SetTop(tempImg, y);
            testCanvas.Children.Add(tempImg);
        }

     

        private void randomClick(object sender, RoutedEventArgs e) {
            Random rnd = new Random();
            updatePNG((BitmapImage)eyesArr[rnd.Next(0, 2)], 100);
            updatePNG((BitmapImage)mouthArr[rnd.Next(0, 2)], 300);
            updatePNG((BitmapImage)noseArr[rnd.Next(0, 2)], 200);
            updatePNG((BitmapImage)hairArr[rnd.Next(0, 2)], 0);

        }


        private void hair1Click(object sender, RoutedEventArgs e)
        {
            updatePNG(hair1,0);
        }
        
        private void hair2Click(object sender, RoutedEventArgs e)
        {
            updatePNG(hair2, 0);
        }
        private void nose1Click(object sender, RoutedEventArgs e)
        {
            updatePNG(nose1, 200);
        }
        private void nose2Click(object sender, RoutedEventArgs e)
        {
            updatePNG(nose2, 200);
        }
        private void eyes1Click(object sender, RoutedEventArgs e)
        {
            updatePNG(eyes1, 100);
        }
        private void eyes2Click(object sender, RoutedEventArgs e)
        {
            updatePNG(eyes2, 100);
        }
        private void mouth1Click(object sender, RoutedEventArgs e)
        {
            updatePNG(mouth1, 300);
        }
        private void mouth2Click(object sender, RoutedEventArgs e)
        {
            updatePNG(mouth2, 300);
        }
    }
}
