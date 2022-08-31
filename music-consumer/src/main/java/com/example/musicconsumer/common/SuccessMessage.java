package com.example.musicconsumer.common;

import com.alibaba.fastjson.JSONObject;

public class SuccessMessage {
    JSONObject jsonObject = new JSONObject();
    public SuccessMessage(String message) {
        jsonObject.put("code", 200);
        jsonObject.put("message", message);
        jsonObject.put("success", true);
        jsonObject.put("type", "success");
        jsonObject.put("data", null);
    }
    public JSONObject getMessage() {
        return jsonObject;
    }
}
