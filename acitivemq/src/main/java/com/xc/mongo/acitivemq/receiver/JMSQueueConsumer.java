package com.xc.mongo.acitivemq.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-03-08
 * @ Description：
 */
public class JMSQueueConsumer {

    public static void main(String[] args) {
        // 连接工厂
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory
                        ("tcp://127.0.0.1:61616");// mq的端口号
        Connection connection = null;
        try {
            // 通过连接工厂创捷连接,启动
            connection = connectionFactory.createConnection();
            connection.start();
            // 通过连接创建会话  AUTO_ACKNOWLEDGE  自动确认   CLIENT_ACKNOWLEDGE 客户端确认消息签收 DUPS_OK_ACKNOWLEDGE 延迟确认
            Session session = connection.createSession
//                    (Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
                    (Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            //通过会话创建目的地
            Destination destination = session.createQueue("myQueue");
            //创建发送者
            MessageConsumer consumer=session.createConsumer(destination);
            for(int i=0;i<10;i++) {
                TextMessage textMessage = (TextMessage) consumer.receive();// 阻塞方式
                System.out.println(textMessage.getText());
                if(i==3) {
                    System.out.println("1111111111111111111111111111111111111");
                    textMessage.acknowledge();//  只有这个消息是被确认的，其余的都是可以重复消费，处理消息异常的考虑
                }
            }
//          session.commit();//表示消息被自动确认
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
