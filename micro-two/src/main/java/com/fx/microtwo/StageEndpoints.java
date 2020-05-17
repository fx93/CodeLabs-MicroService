package com.fx.microtwo;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "stages") // actuator/stages traffic routing
public class StageEndpoints {

    Map<String, Stage> stages=new ConcurrentHashMap<>();

    @ReadOperation //get call will come here and map
    public Map<String, Stage> getAllStages(){
        return stages;
    }

    @ReadOperation
    public Stage getStage(@Selector String name){
        return stages.get(name);
    }

    @WriteOperation
    public void setValue(@Selector String name, int stage){
        stages.put(name, new Stage(stage));
    } // selector always has to be mentioned in url



    static class Stage{
        int value;

        public Stage(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
