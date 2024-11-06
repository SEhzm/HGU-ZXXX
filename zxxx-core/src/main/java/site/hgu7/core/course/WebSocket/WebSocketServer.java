package site.hgu7.core.course.WebSocket;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * WebSocket服务
 */
@Component
@ServerEndpoint("/ws/{sid}")
public class WebSocketServer {


    //存放会话对象
    private static Map<String, Session> sessionMap = new HashMap();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
//        System.out.println("客户端：" + sid + "建立连接");
        PageHelper.clearPage();

        // 将新连接的客户端会话存储到会话映射中
        sessionMap.put(sid, session);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, @PathParam("sid") String sid) {

//        System.out.println("收到来自客户端：" + sid + "的信息:" + message);
        // 使用fastjson解析JSON字符串
        JSONObject jsonObject = JSONObject.parseObject(message);
        // 提取字段
        String type = jsonObject.getString("type");
        String msg = jsonObject.getString("message");
        String userId = jsonObject.getString("userId");
        String time = jsonObject.getString("time");
        PageHelper.clearPage();
        // 广播消息
        sendToAllClient(message);
    }

    /**
     * 连接关闭调用的方法
     *
     * @param sid
     */
    @OnClose
    public void onClose(@PathParam("sid") String sid) {
//        System.out.println("连接断开:" + sid);
        sessionMap.remove(sid);
    }

    /**
     * 群发
     *
     * @param message
     */
    public void sendToAllClient(String message) {
        Collection<Session> sessions = sessionMap.values();
        for (Session session : sessions) {
            try {
                //服务器向客户端发送消息
                session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Throwable error, Session session, @PathParam("sid") String sid) {
        sessionMap.remove(sid);
    }

    public int getAlluserCnt() {
        int size = sessionMap.size();
        return size;
    }

    //每天05：00执行  不删记录了，md
//    @Scheduled(cron = "0 0 5 ? * ? ")
//    public void sendMessageToClient() {
//        machineChatMapper.delete7DayAgo();
//    }
}