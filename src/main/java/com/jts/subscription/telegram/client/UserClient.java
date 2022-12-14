package com.jts.subscription.telegram.client;

import com.jts.subscription.telegram.data.dto.SystemUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "ms-users", url = "localhost:8083/users")
public interface UserClient {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    void saveUser(@RequestBody SystemUser systemUser);

    @RequestMapping(value = "/getID/{telegramId}", method = RequestMethod.GET)
    UUID getUserIdByTelegramId(@PathVariable String telegramId);

}
