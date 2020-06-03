package com.family.bbkingweb.websocket;


import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.LinkedHashMap;
import java.util.Map;

@ServerEndpoint(value = "/websocket") //接受websocket请求路径
@Component
public class PoundWebSocket {

}