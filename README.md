# 网络编程

### 协议

#### UDP协议

* 用户数据报协议(User Datagram Protocol)
* UDP是面向无连接通信协议。
* **速度快，有大小限制一次最多发送64K,数据不安全，易丢失数据**
* 使用场景：语音通话，视频直播

#### TCP协议

* 传输控制协议TCP(Transmission Control Protocol)
* TCP协议是面向连接的通信协议。
* **速度慢，没有大小限制，数据安全。**
* 使用场景：软件下载



### InetAddress的使用

获取电脑 IP 的对象

```java
        InetAddress address = InetAddress.getByName("IIIce");
        System.out.println(address);

        String hostName = address.getHostName();
        System.out.println(hostName);

        String ip = address.getHostAddress();
        System.out.println(ip);
```



### UDP 通讯协议

#### 步骤

1. 创建发送端的 DatagramSocket 对象
2. 数据打包（DataGramPacket）
3. 发送数据
4. 释放资源

#### 发送数据实现

```java
try (DatagramSocket socket = new DatagramSocket()) {
            String s = "Hello!!!";
            byte[] bytes = s.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 10086);

            socket.send(packet);

        } catch (Exception e) {
            System.out.println("error");

        }
```



#### 接收数据实现

```java
        // 接收时，一定要绑定端口和发送端一致
		DatagramSocket socket = new DatagramSocket(10086);
		
		// 接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        socket.receive(dp);
		
		// 解析数据包
        byte[] data = dp.getData();
        int length = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();

        System.out.println(new String(data,0,length));
        
        socket.close();
```

#### UDP 的三种通讯方式

* 单播：以前的代码就是单播
* 组播：组播地址：224.0.0.0~239.255.255.255
  ，其中224.0.0.0~224.0.0.255为预留的组播地址
* 广播：广播地址：255.255.255.255

#### 代码实现组播

##### Sender

```java
MulticastSocket ms = new MulticastSocket();
        String s = "hello everyone";
        byte[] bytes = s.getBytes();
        InetAddress addresses = InetAddress.getByName("224.0.0.1");
        int port = 10000;

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, addresses, port);

        ms.send(packet);

        ms.close();
```

##### Receiver

```java
 MulticastSocket ms = new MulticastSocket(10000);
        InetAddress address = InetAddress.getByName("224.0.0.1");

        ms.joinGroup(address);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        ms.receive(dp);

        byte[] data = dp.getData();
        int length = dp.getLength();
        String ip = dp.getAddress().getHostAddress();
        String name = dp.getAddress().getHostName();

        System.out.println(ip + "  " + name + " : " + new String(data, 0, length));
```



### TCP 通讯协议

TCP 通信协议是一种可靠的网络协议，它在通信的两端各建立一个 Socket 对象。通信之前要保证连接已经建立，通过 Socket 产生 IO 流来进行网络通信![image-20230330231828477](https://cdn.jsdelivr.net/gh/KingRainIce/typora-pic@main/202303302318950.png)

#### Clint 端代码

```java
        Socket socket = new Socket("127.0.0.1", 10000);

        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());

        os.close();
        socket.close();
```



#### Server 端代码

```java
        ServerSocket socket = new ServerSocket(10000);

        Socket accept = socket.accept();
        InputStream is = accept.getInputStream();

        int b = 0;
        while ((b = is.read()) != -1){
            System.out.println((char) b);
        }
        accept.close();
        socket.close();
```

> 以上代码有问题，若传输中文字符则会出现乱码问题，所以输出中文的时候应该使用字符流：`InputStreamReader reader = new InputStreamReader(is);`也可以使用缓冲流来提高效率



#### 细节问题

1. 三次握手协议来保证连接建立![image-20230330234942713](https://cdn.jsdelivr.net/gh/KingRainIce/typora-pic@main/202303302349856.png)
2. 四次挥手协议保证断开连接时通道里面的数据处理完毕![image-20230330235045523](https://cdn.jsdelivr.net/gh/KingRainIce/typora-pic@main/202303302350847.png)
3. 当 socket 关闭时其中的数据流也会关闭
