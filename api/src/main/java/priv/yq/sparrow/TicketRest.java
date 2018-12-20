package priv.yq.sparrow;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.yq.sparrow.dto.TicketDTO;
import priv.yq.sparrow.result.Result;

/**
 * Created by yaoqing on 2018/12/20.
 */
@RestController
@RequestMapping(value = "/ticket")
public interface TicketRest {

    @PostMapping(value = "/buy")
    Result buy(@RequestBody TicketDTO ticketDTO);

}
