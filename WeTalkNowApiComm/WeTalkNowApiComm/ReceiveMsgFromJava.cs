using System;
using System.Text;
using System.Net.Sockets;
using System.Net;

namespace WeTalkNowApiComm
{
    class ReceiveMsgFromJava
    {
        public String rec(String msgReceived)
        {
            IPEndPoint endpoint = null;
            Socket sck = null;
            

            try
            {
                endpoint = new IPEndPoint(IPAddress.Any, 8888);
                sck = new Socket(AddressFamily.InterNetwork, SocketType.Dgram, ProtocolType.Udp);
                sck.ExclusiveAddressUse = false;
                sck.SetSocketOption(SocketOptionLevel.Socket, SocketOptionName.ReuseAddress, true);
                
                byte[] data = new byte[1024];

                sck.Bind(endpoint);


                Console.WriteLine("Waiting for message from Java .. \r\n");

                EndPoint remote = (EndPoint)endpoint;



                int recv = sck.ReceiveFrom(data, ref remote);

                msgReceived = Encoding.ASCII.GetString(data, 0, recv);
                Console.WriteLine("Message from Java : " + msgReceived);

                
            }
            catch (Exception error)
            {
                Console.WriteLine(error);
            }
            finally
            {
                sck.Dispose();

            }

            return msgReceived;


        }
    }
}