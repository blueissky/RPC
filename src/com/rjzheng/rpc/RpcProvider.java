package com.rjzheng.rpc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class RpcProvider {
	//�洢ע��ķ����б�
    private static List<Object> serviceList;
    
    /**
     * ����rpc����
     * @param object
     * @param port
     * @throws Exception
     */
    public static void export(int port,Object... services) throws Exception {
        serviceList=Arrays.asList(services);
        ServerSocket server = new ServerSocket(port);
        Socket client = null;
        while (true) {
            //�����ȴ�����
            client = server.accept();
            //ÿһ����������һ���̴߳���
            new Thread(new ServerThread(client,serviceList)).start();
        }
    }
}
