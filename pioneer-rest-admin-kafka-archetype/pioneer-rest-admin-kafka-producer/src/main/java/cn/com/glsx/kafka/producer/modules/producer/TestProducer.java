package cn.com.glsx.kafka.producer.modules.producer;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author payu
 */
@Slf4j
@Component
public class TestProducer {

    @Autowired
    private Producer producer;

    public void sendMsg(String message) {
        KeyedMessage<byte[], byte[]> messageBody = new KeyedMessage<>("test_topic", message.getBytes(), message.getBytes());
        producer.send(messageBody);
        log.info(message);
    }

}
