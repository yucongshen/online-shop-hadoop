package cn.ssh.shop.test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

public class ProducerDemo{
	//指定具体的topic
	private String topic;
	
	public ProducerDemo(String topic){
		this.topic = topic;
	}
	
	//每隔5秒发送一条消息
	public void sendMessage(String kafkaMessage){
		//创建一个producer的对象
		Producer producer = createProducer();
		
		//发送消息
			
		//使用produer发送消息
		producer.send(new KeyedMessage(this.topic, kafkaMessage));
		
		//打印
		System.out.println("发送数据：" + kafkaMessage);
	}
	
	//创建Producer的实例
	private Producer createProducer() {
		Properties prop = new Properties();
		
		//声明zk
		prop.put("zookeeper.connect", "192.168.1.10:2181,192.168.1.11:2181,192.168.1.12:2181");
		prop.put("serializer.class",StringEncoder.class.getName());
		
		//声明Broker的地址
		prop.put("metadata.broker.list","192.168.1.10:9092");
		
		return new Producer(new ProducerConfig(prop));
	}
	public static void main(String[] args) {
		ProducerDemo producer=new ProducerDemo("syc");
		producer.sendMessage("cc");
	}
}
