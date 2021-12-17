package com.accenture.russiaatc.irentservice.telegram.commands;

import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import com.accenture.russiaatc.irentservice.model.dto.TransportShortDto;
import com.accenture.russiaatc.irentservice.model.dto.UserDto;
import com.accenture.russiaatc.irentservice.service.rent.RentService;
import com.accenture.russiaatc.irentservice.service.transport.TransportService;
import com.accenture.russiaatc.irentservice.service.user.UserService;
import com.accenture.russiaatc.irentservice.telegram.TelegramUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Slf4j
@Component
public class RentCommand extends BaseCommand {

    private final TelegramUtils utils;
    private final UserService userService;
    private final TransportService transportService;
    private final RentService rentService;

    @Autowired
    public RentCommand(TelegramUtils utils, TelegramUtils utils1, UserService userService, TransportService transportService, RentService rentService) {
        super("rent", "rent command", utils);
        this.utils = utils1;
        this.userService = userService;
        this.transportService = transportService;
        this.rentService = rentService;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        log.info("Telegram RENT command received");
        try {
            String message;
            UserDto userDto = userService.findByLogin(user.getUserName());
            TransportShortDto tsd = transportService.findBySerial(strings[0]);
            RentDto createdRentDto = rentService.createRent(userDto.getId(), tsd.getId());
            if (createdRentDto != null) {
                message = String.format("Поздравляю, вы арендовали %s, ваша аренда началась в %s", tsd.getSerial(), createdRentDto.getStartDateTime());
            }
            else {
                message = String.format("Простите, что-то пошло не так, арендовать %s не получилось", tsd.getSerial());
            }
            utils.send(absSender, chat.getId(), message, ParseMode.HTML,false);
        }
        catch (Exception ex) {
            log.error("Ошибка обработки команды rent", ex);
        }
    }
}
