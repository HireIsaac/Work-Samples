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
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

using RadioButton = System.Windows.Controls.RadioButton;

namespace M05

{

    public partial class MainWindow : Window
    {

        HelpNavigator Nav = new HelpNavigator();

        private CommandHandler HairNextCommand;
        private CommandHandler HairLastCommand;
        private CommandHandler EyesNextCommand;
        private CommandHandler EyesLastCommand;
        private CommandHandler MouthNextCommand;
        private CommandHandler MouthLastCommand;
        private CommandHandler NoseNextCommand;
        private CommandHandler NoseLastCommand;

        private int currentHair;
        private int currentEyes;
        private int currentMouth;
        private int currentNose;

        private ArrayList hairArr = new ArrayList();
        private ArrayList eyesArr = new ArrayList();
        private ArrayList noseArr = new ArrayList();
        private ArrayList mouthArr = new ArrayList();

        private BitmapImage hair1 = new BitmapImage(new Uri("../../hair1.png", UriKind.Relative));
        private BitmapImage hair2 = new BitmapImage(new Uri("../../hair2.png", UriKind.Relative));
        private BitmapImage hair3 = new BitmapImage(new Uri("../../hair3.png", UriKind.Relative));
        private BitmapImage eyes1 = new BitmapImage(new Uri("../../eyes1.png", UriKind.Relative));
        private BitmapImage eyes2 = new BitmapImage(new Uri("../../eyes2.png", UriKind.Relative));
        private BitmapImage eyes3 = new BitmapImage(new Uri("../../eyes3.png", UriKind.Relative));
        private BitmapImage nose1 = new BitmapImage(new Uri("../../nose1.png", UriKind.Relative));
        private BitmapImage nose2 = new BitmapImage(new Uri("../../nose2.png", UriKind.Relative));
        private BitmapImage nose3 = new BitmapImage(new Uri("../../nose3.png", UriKind.Relative));
        private BitmapImage mouth1 = new BitmapImage(new Uri("../../mouth1.png", UriKind.Relative));
        private BitmapImage mouth2 = new BitmapImage(new Uri("../../mouth2.png", UriKind.Relative));
        private BitmapImage mouth3 = new BitmapImage(new Uri("../../mouth3.png", UriKind.Relative));

        public MainWindow()
        {
            Nav = HelpNavigator.Topic;

            HairNextCommand = new CommandHandler(nextHairAction, true);
            HairLastCommand = new CommandHandler(lastHairAction, true);
            EyesNextCommand = new CommandHandler(nextEyesAction, true);
            EyesLastCommand = new CommandHandler(lastEyesAction, true);
            MouthNextCommand = new CommandHandler(nextMouthAction, true);
            MouthLastCommand = new CommandHandler(lastMouthAction, true);
            NoseNextCommand = new CommandHandler(nextNoseAction, true);
            NoseLastCommand = new CommandHandler(lastNoseAction, true);

            DataContext = new
            {
                NextHairCommand = HairNextCommand,
                LastHairCommand = HairLastCommand,
                NextEyesCommand = EyesNextCommand,
                LastEyesCommand = EyesLastCommand,
                NextMouthCommand = MouthNextCommand,
                LastMouthCommand = MouthLastCommand,
                NextNoseCommand = NoseNextCommand,
                LastNoseCommand = NoseLastCommand

            };
            InitializeComponent();
            hairArr.Add(hair1);
            hairArr.Add(hair2);
            hairArr.Add(hair3);
            eyesArr.Add(eyes1);
            eyesArr.Add(eyes2);
            eyesArr.Add(eyes3);
            noseArr.Add(nose1);
            noseArr.Add(nose2);
            noseArr.Add(nose3);
            mouthArr.Add(mouth1);
            mouthArr.Add(mouth2);
            mouthArr.Add(mouth3);

            InputBindings.Add(new KeyBinding(HairNextCommand, new KeyGesture(Key.L, ModifierKeys.Control)));
            InputBindings.Add(new KeyBinding(HairLastCommand, new KeyGesture(Key.K, ModifierKeys.Control)));
            InputBindings.Add(new KeyBinding(EyesNextCommand, new KeyGesture(Key.J, ModifierKeys.Control)));
            InputBindings.Add(new KeyBinding(EyesLastCommand, new KeyGesture(Key.H, ModifierKeys.Control)));
            InputBindings.Add(new KeyBinding(NoseNextCommand, new KeyGesture(Key.P, ModifierKeys.Control)));
            InputBindings.Add(new KeyBinding(NoseLastCommand, new KeyGesture(Key.O, ModifierKeys.Control)));
            InputBindings.Add(new KeyBinding(MouthNextCommand, new KeyGesture(Key.I, ModifierKeys.Control)));
            InputBindings.Add(new KeyBinding(MouthLastCommand, new KeyGesture(Key.U, ModifierKeys.Control)));

        }





        /*PNG updater:*/

        private void updatePNG(BitmapImage i, double y)
        {
            Image tempImg = new Image();
            tempImg.Source = i;
            tempImg.Width = i.Width;
            tempImg.Height = i.Height;

            Canvas.SetLeft(tempImg, 0);
            Canvas.SetTop(tempImg, y);
            testCanvas.Children.Add(tempImg);
        }







        /*Click functions:*/

        private void randomClick(object sender, RoutedEventArgs e)
        {
            Random rnd = new Random();
            updatePNG((BitmapImage)eyesArr[rnd.Next(0, 3)], 100);
            updatePNG((BitmapImage)mouthArr[rnd.Next(0, 3)], 300);
            updatePNG((BitmapImage)noseArr[rnd.Next(0, 3)], 200);
            updatePNG((BitmapImage)hairArr[rnd.Next(0, 3)], 0);

        }

        private void hairRadioButton_Checked(object sender, RoutedEventArgs e)
        {
            RadioButton rb = sender as RadioButton;
            if (rb != null)
            {
                string hairName = rb.Tag.ToString();
                hairLogic(hairName);
            }
        }

        private void noseRadioButton_Checked(object sender, RoutedEventArgs e)
        {
            RadioButton rb = sender as RadioButton;
            if (rb != null)
            {
                string noseName = rb.Tag.ToString();
                noseLogic(noseName);
            }
        }

        private void eyesRadioButton_Checked(object sender, RoutedEventArgs e)
        {
            RadioButton rb = sender as RadioButton;
            if (rb != null)
            {
                string eyesName = rb.Tag.ToString();
                eyesLogic(eyesName);
            }
        }

        private void mouthRadioButton_Checked(object sender, RoutedEventArgs e)
        {
            RadioButton rb = sender as RadioButton;
            if (rb != null)
            {
                string mouthName = rb.Tag.ToString();
                mouthLogic(mouthName);
            }
        }






        /*Logic for button clicks:*/

        private void hairLogic(string Hair)
        {
            switch (Hair)
            {
                case "hair_1":
                    currentHair = 0;
                    updatePNG(hair1, 0);
                    break;
                case "hair_2":
                    currentHair = 1;
                    updatePNG(hair2, 0);
                    break;
                case "hair_3":
                    currentHair = 2;
                    updatePNG(hair3, 0);
                    break;

            }
        }

        private void noseLogic(string nose)
        {
            switch (nose)
            {
                case "nose_1":
                    updatePNG(nose1, 200);
                    break;
                case "nose_2":
                    updatePNG(nose2, 200);
                    break;
                case "nose_3":
                    updatePNG(nose3, 200);
                    break;

            }

        }

        private void eyesLogic(string eyes)
        {
            switch (eyes)
            {
                case "eyes_1":
                    updatePNG(eyes1, 100);
                    break;
                case "eyes_2":
                    updatePNG(eyes2, 100);
                    break;
                case "eyes_3":
                    updatePNG(eyes3, 100);
                    break;

            }


        }

        private void mouthLogic(string mouth)
        {
            switch (mouth)
            {
                case "mouth_1":
                    updatePNG(mouth1, 300);
                    break;
                case "mouth_2":
                    updatePNG(mouth2, 300);
                    break;
                case "mouth_3":
                    updatePNG(mouth3, 300);
                    break;

            }
        }



        /*Next / last buttons:*/

        private void nextLoad(string bodyPart)
        {

            switch (bodyPart)
            {
                case "mouth":
                    int newIndexM = currentMouth + 1;
                    if (newIndexM >= mouthArr.Count)
                    {
                        newIndexM = 0;
                    }
                    currentMouth = newIndexM;

                    updatePNG((BitmapImage)mouthArr[newIndexM], 300);
                    break;

                case "hair":
                    int newIndexH = currentHair + 1;
                    if (newIndexH >= hairArr.Count)
                    {
                        newIndexH = 0;
                    }
                    currentHair = newIndexH;

                    updatePNG((BitmapImage)hairArr[newIndexH], 0);
                    break;

                case "eyes":
                    int newIndexE = currentEyes + 1;
                    if (newIndexE >= eyesArr.Count)
                    {
                        newIndexE = 0;
                    }
                    currentEyes = newIndexE;

                    updatePNG((BitmapImage)eyesArr[newIndexE], 100);
                    break;

                case "nose":
                    int newIndexN = currentNose + 1;
                    if (newIndexN >= noseArr.Count)
                    {
                        newIndexN = 0;
                    }
                    currentNose = newIndexN;

                    updatePNG((BitmapImage)noseArr[newIndexN], 200);
                    break;


            }
        }


        private void lastLoad(string bodyPart)
        {

            switch (bodyPart)
            {
                case "mouth":
                    int newIndexM = currentMouth - 1;
                    if (newIndexM < 0)
                    {
                        newIndexM = mouthArr.Count - 1;
                    }
                    currentMouth = newIndexM;

                    updatePNG((BitmapImage)mouthArr[newIndexM], 300);
                    break;

                case "hair":
                    int newIndexH = currentHair - 1;
                    if (newIndexH < 0)
                    {
                        newIndexH = hairArr.Count - 1;
                    }
                    currentHair = newIndexH;

                    updatePNG((BitmapImage)hairArr[newIndexH], 0);
                    break;

                case "eyes":
                    int newIndexE = currentEyes - 1;
                    if (newIndexE < 0)
                    {
                        newIndexE = eyesArr.Count - 1;
                    }
                    currentEyes = newIndexE;

                    updatePNG((BitmapImage)eyesArr[newIndexE], 100);
                    break;

                case "nose":
                    int newIndexN = currentNose - 1;
                    if (newIndexN < 0)
                    {
                        newIndexN = noseArr.Count - 1;
                    }
                    currentNose = newIndexN;

                    updatePNG((BitmapImage)noseArr[newIndexN], 200);
                    break;


            }
        }




        /*Actions:*/

        private void nextHairAction()
        {
            nextLoad("hair");
        }
        private void lastHairAction()
        {
            lastLoad("hair");
        }
        private void nextEyesAction()
        {
            nextLoad("eyes");
        }
        private void lastEyesAction()
        {
            lastLoad("eyes");
        }
        private void nextNoseAction()
        {
            nextLoad("nose");
        }
        private void lastNoseAction()
        {
            lastLoad("nose");
        }
        private void nextMouthAction()
        {
            nextLoad("mouth");
        }
        private void lastMouthAction()
        {
            lastLoad("mouth");
        }


        /*help:*/
        private void helpMe(string pageName) {
            Help.ShowHelp(null, "../../helpM05.chm", Nav, pageName + ".htm");
        }

        private void helpButton(object sender, RoutedEventArgs e) {
            FrameworkElement frameE = sender as FrameworkElement;
            if (frameE != null) {
                string helpO = frameE.Tag.ToString();
                helpMe(helpO);
            }
        }

        
    }
}