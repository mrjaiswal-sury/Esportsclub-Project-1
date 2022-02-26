import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
    private static final String QUEUE_NAME="hello";

    public static void send(String message) throws Exception{
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        try(Connection connection= factory.newConnection();
        Channel channel= connection.createChannel()){
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
//        String message = "Hello World!";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("[x] Sent: "+message);
        }
    }
}
