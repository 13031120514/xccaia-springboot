package com.xccaia.acitivemq.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-03-08
 * @ Description：发送消息
 */
public class JMSQueueProducer {

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
            // 通过连接创建会话  transacted  FALSE/TRUE 事物
            Session session = connection.createSession
                    (Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            //通过会话创建目的地
            Destination destination = session.createQueue("myQueue");
            //通过会话创建发送者
            MessageProducer producer = session.createProducer(destination);
            // 持久化
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
//            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            for (int i = 0; i < 10; i++) {
                //创建需要发送的消息
                TextMessage message = session.createTextMessage("Hello World:" + i);
                //Text   Map  Bytes  Stream  Object 消息体的格式
                producer.send(message);
                System.out.println(message.getText());
            }
//            session.commit(); Boolean.TRUE   session.rollback();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
