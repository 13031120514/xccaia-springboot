package com.xc.mongo.acitivemq.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-03-08
 * @ Description：持久化订阅消息
 */
public class JMSPersistentTopicConsumer {

  public static void main(String[] args) {
    ConnectionFactory connectionFactory =
        new ActiveMQConnectionFactory
            ("tcp://127.0.0.1:61616");
    Connection connection = null;
    try {

      connection = connectionFactory.createConnection();
      // 持久化配置 需要唯一 客户端向jms服务器先注册客户ID,持久化broker上
      connection.setClientID("xccaia-001");

      connection.start();

      Session session = connection.createSession
          (Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
      //创建目的地
      Topic destination = session.createTopic("myTopic");
      //创建发送者
//            MessageConsumer consumer=session.createConsumer(destination);
      MessageConsumer consumer = session.createDurableSubscriber(destination, "xccaia-001");

      TextMessage textMessage = (TextMessage) consumer.receive();
      System.out.println(textMessage.getText());

//            session.commit(); //消息被确认

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
