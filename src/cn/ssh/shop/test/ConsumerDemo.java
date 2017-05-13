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

	//指定具体的topic
	private String topic;
	
	public ConsumerDemo(String topic){
		this.topic = topic;
	}
	
	public void run(){
		//构造一个consumer的对象
		ConsumerConnector consumer = createConsumer();
		
		//构造一个Map对象，代表topic
		//String: topic的名称  Integer: 从这个topic中获取多少条记录
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		//一次从这个topic中获取一条记录
		topicCountMap.put(this.topic, 1);
		
		//构造一个messageStream：输入流
		//String: topic的名称 List: 获取的数据
		Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = consumer.createMessageStreams(topicCountMap);
		
		//获取每次接受到的具体的数据
		KafkaStream<byte[], byte[]> stream = messageStreams.get(this.topic).get(0);
		
		ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
		while(iterator.hasNext()){
			String message = new String(iterator.next().message());
			
			System.out.println("接受数据：" + message);
			MailUtils.sendMail("490603883@qq.com", message);
		}
	}
	
	//创建具体的consumer
	private ConsumerConnector createConsumer() {
		Properties prop = new Properties();
		
		//指明zk的地址
		prop.put("zookeeper.connect", "192.168.1.10:2181,192.168.1.11:2181,192.168.1.12:2181");
		
		//指明这个consumer的消费组
		prop.put("group.id", "group1");
		
		return Consumer.createJavaConsumerConnector(new ConsumerConfig(prop));
	}

	public static void main(String[] args) {
		new ConsumerDemo("syc").start();
	}

}
