package cn.ssh.shop.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class ConsumerDemo extends Thread {

	//ָ�������topic
	private String topic;
	
	public ConsumerDemo(String topic){
		this.topic = topic;
	}
	
	public void run(){
		//����һ��consumer�Ķ���
		ConsumerConnector consumer = createConsumer();
		
		//����һ��Map���󣬴���topic
		//String: topic������  Integer: �����topic�л�ȡ��������¼
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		//һ�δ����topic�л�ȡһ����¼
		topicCountMap.put(this.topic, 1);
		
		//����һ��messageStream��������
		//String: topic������ List: ��ȡ������
		Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = consumer.createMessageStreams(topicCountMap);
		
		//��ȡÿ�ν��ܵ��ľ��������
		KafkaStream<byte[], byte[]> stream = messageStreams.get(this.topic).get(0);
		
		ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
		while(iterator.hasNext()){
			String message = new String(iterator.next().message());
			
			System.out.println("�������ݣ�" + message);
			MailUtils.sendMail("490603883@qq.com", message);
		}
	}
	
	//���������consumer
	private ConsumerConnector createConsumer() {
		Properties prop = new Properties();
		
		//ָ��zk�ĵ�ַ
		prop.put("zookeeper.connect", "192.168.1.10:2181,192.168.1.11:2181,192.168.1.12:2181");
		
		//ָ�����consumer��������
		prop.put("group.id", "group1");
		
		return Consumer.createJavaConsumerConnector(new ConsumerConfig(prop));
	}

	public static void main(String[] args) {
		new ConsumerDemo("syc").start();
	}

}
