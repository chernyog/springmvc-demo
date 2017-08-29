package com.pintec.demo.controller;

import com.pintec.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;

@Controller
public class DemoController extends BaseController {

    @RequestMapping(value = "/sayhello/{sb}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("sb") String sb, ModelMap map, @RequestParam String name) {
        print("hello " + sb);
        print("name " + name);
        Person p = new Person();
        p.setId(new Random().nextInt(10000));
        p.setName("admin");
        p.setSex(new Random().nextBoolean());
        map.put("person", p);
        map.put("name", sb);
        print(p.toString());
        return "/demo";
    }

    @RequestMapping(value = "/sayhello", method = RequestMethod.GET)
    public String sayHello(ModelMap map, @RequestParam String name) {
        print("name " + name);
        Person p = new Person();
        p.setId(new Random().nextInt(10000));
        p.setName(name);
        p.setSex(new Random().nextBoolean());
        map.put("person", p);
        map.put("name", name);
        print(p.toString());
        return "/demo";
    }

    @RequestMapping(value = "/sayhello", method = RequestMethod.POST)
    public String sayHello_(ModelMap map, @RequestBody String name) {
        print("hello " + name);
        Person p = new Person();
        p.setId(new Random().nextInt(10000));
        p.setName(name);
        p.setSex(new Random().nextBoolean());
        map.put("person", p);
        map.put("name", name);
        print(p.toString());
        return "/demo";
    }

    @ResponseBody  // 加这个注解，说明返回的是 json 对象，否则就是页面跳转
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") int id) {
        // 根据 id 获取到指定对象
        ArrayList<Person> dataArray = initData();
        Object[] filterList = dataArray.stream().filter(obj->obj.getId() == id).limit(1).toArray();
        if (filterList.length < 1) { return null; }
        return (Person) filterList[0];
//        dataArray.forEach(($0) -> {
//
//        });
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Person getPerson() {
        ArrayList<Person> dataArray = initData();
        int index = new Random().nextInt() % dataArray.size();
        return dataArray.get(index);
    }

    private void print(Object msg) {
        System.out.println(msg);
    }

    private ArrayList<Person> initData() {
        ArrayList<Person> _dataArray = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Person p = new Person();
            p.setId(i);
            p.setName("admin" + i);
            p.setSex(new Random().nextBoolean());
            _dataArray.add(p);
        }
        return _dataArray;
    }

}
