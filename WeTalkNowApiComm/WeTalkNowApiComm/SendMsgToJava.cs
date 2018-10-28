using System;
using System.Net.Sockets;
using System.Net;

namespace WeTalkNowApiComm
{
    class SendMsgToJava
    {
       public static System.Net.IPAddress ipAdd = System.Net.IPAddress.Parse("127.0.0.1");
       public static System.Net.IPEndPoint remoteEP = new IPEndPoint(ipAdd, 8081);

        public void send(String response)
        {
            Socket sck = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            try
            {
                
                sck.Connect(remoteEP);

                byte[] byData = System.Text.Encoding.ASCII.GetBytes(response);
                
                sck.Send(byData);
                

            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }finally {
                sck.Dispose();
            }

        }
    }
}
