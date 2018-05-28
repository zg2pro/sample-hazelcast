package com.github.zg2pro.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Component
public class MapUpdatesService implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    private IMap<Object, Object> map;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        map = hazelcastInstance.getMap("distributedConfig");
        map.putIfAbsent("xyz", "abc");
        map.putIfAbsent("123", "mno");
    }

    public IMap<Object, Object> getMap() {
        return map;
    }

    public void setMap(IMap<Object, Object> map) {
        this.map = map;
    }
}
