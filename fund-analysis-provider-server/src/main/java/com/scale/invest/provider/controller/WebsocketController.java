package com.scale.invest.provider.controller;

import com.scale.invest.api.dto.socket.SocketStoreInfoDTO;
import com.scale.invest.provider.component.socket.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebsocketController {

    @Autowired
    private WebSocketService webSocketService;

    @PostMapping(value = "/delete/socket/session")
    @ResponseBody
    public String deleteSocketSession(@RequestBody SocketStoreInfoDTO socketStoreInfoDTO) {
        webSocketService.deleteLocalSocketSession(socketStoreInfoDTO);
        return "success";
    }
}
