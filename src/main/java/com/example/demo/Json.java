package com.example.demo;

//import javax.swing.text.html.HTMLDocument.Iterator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;

import java.util.Iterator;
import java.util.Map;

public class Json {




    public void addKeys(String currentPath, JsonNode jsonNode, Map<String, String> map) {
        if (jsonNode.isObject()) {
          ObjectNode objectNode = (ObjectNode) jsonNode;
          Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields();
          String pathPrefix = currentPath.isEmpty() ? "" : currentPath + "_";
    
          while (iter.hasNext()) {
            Map.Entry<String, JsonNode> entry = iter.next();
            addKeys(pathPrefix + entry.getKey(), entry.getValue(), map);
          }
        } else if (jsonNode.isArray()) {
          ArrayNode arrayNode = (ArrayNode) jsonNode;
          for (int i = 0; i < arrayNode.size(); i++) {
            addKeys(currentPath  + i , arrayNode.get(i), map);
          }
        } else if (jsonNode.isValueNode()) {
          ValueNode valueNode = (ValueNode) jsonNode;
          map.put(currentPath, valueNode.asText());
        }
      }




}