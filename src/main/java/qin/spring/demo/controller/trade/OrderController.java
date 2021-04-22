package qin.spring.demo.controller.trade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qin.spring.demo.helpers.response.Resp;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @RequestMapping("list")
    public Object list() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "q");
        map.put("2", "b");

        return Resp.success(map);
    }
}
