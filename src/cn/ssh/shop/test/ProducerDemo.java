package cn.ssh.shop.test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

public class ProducerDemo{
	//ָ�������topic
	private String topic;
	
	public ProducerDemo(String topic){
		this.topic = topic;
	}
	
	//ÿ��5�뷢��һ����Ϣ
	public void sendMessage(String kafkaMessage){
		//����һ��producer�Ķ���
		Producer producer = createProducer();
		
		//������Ϣ
			
		//ʹ��produer������Ϣ
		producer.send(new KeyedMessage(this.topic, kafkaMessage));
		
		//��ӡ
		System.out.println("�������ݣ�" + kafkaMessage);
	}
	
	//����Producer��ʵ��
	private Producer createProducer() {
		Properties prop = new Properties();
		
		//����zk
		prop.put("zookeeper.connect", "192.168.1.10:2181,192.168.1.11:2181,192.168.1.12:2181");
		prop.put("serializer.class",StringEncoder.class.getName());
		
		//����Broker�ĵ�ַ
		prop.put("metadata.broker.list","192.168.1.10:9092");
		
		return new Producer(new ProducerConfig(prop));
	}
	public static void main(String[] args) {
		ProducerDemo producer=new ProducerDemo("syc");
		producer.sendMessage("cc");
	}
}
