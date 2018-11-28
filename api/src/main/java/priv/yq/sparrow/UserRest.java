package priv.yq.sparrow;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.yq.sparrow.result.Result;

/**
 * Created by yaoqing on 2018/11/28.
 */
@RestController
@RequestMapping(value = "/user")
public interface UserRest {

    @PostMapping(value = "/register")
    Result register(@RequestBody String dataJson);

}
