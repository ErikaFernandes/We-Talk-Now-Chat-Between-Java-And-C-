using System;

namespace WeTalkNowApiComm
{
    class Program
    {
        static void Main(string[] args)
        {

            String resp = null;
            String receive = "";
            
            

            while (!receive.Equals("END"))
            {

           Console.WriteLine("--------------------------------------------------\r\n");

            var receiveFJava = new ReceiveMsgFromJava();
            receive = receiveFJava.rec(receive);


            Console.WriteLine("--------------------------------------------------\r\n");

            var SendTJava = new SendMsgToJava();
            Console.WriteLine("Type your response .. ");
            resp = Console.ReadLine();

            SendTJava.send(resp);
            
            }

            Console.WriteLine("--------------------------------------------------\r\n");

            Console.WriteLine("Press enter to close...");
            Console.ReadLine();


        }
    }
}
