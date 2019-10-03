package com.example.restwebservice.controller;

import com.example.restwebservice.model.Topic;
import com.example.restwebservice.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    @DeleteMapping
    public List<Topic> index() {
        return topicService.getAll();
    }

    @RequestMapping("/topics/{id}")
    public Topic show(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void store(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
