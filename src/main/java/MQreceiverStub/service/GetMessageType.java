package MQreceiverStub.service;

import javax.jms.Message;

public interface GetMessageType {

    Message getMessageType(Message message);

}
