package com.accenture.russiaatc.irentservice.telegram.commands;

import com.accenture.russiaatc.irentservice.model.dto.UserDto;
import com.accenture.russiaatc.irentservice.model.entity.enums.RoleType;

import com.accenture.russiaatc.irentservice.service.user.UserService;
import com.accenture.russiaatc.irentservice.telegram.TelegramUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.math.BigDecimal;

@Slf4j
@Component
public class StartCommand extends BaseCommand {

    private final TelegramUtils utils;
    private final UserService userService;

    @Autowired
    public StartCommand(TelegramUtils utils, UserService userService) {
        super("start", "start command", utils);
        this.utils = utils;
        this.userService = userService;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        log.info("Telegram START command received");
        UserDto userDto;
        try {
            utils.send(absSender, chat.getId(), "Добро пожаловать.", ParseMode.HTML, false);
            userDto = userService.findByLogin(user.getUserName());
            if (userService.userExistByLogin(user.getUserName())) {
                utils.send(absSender, chat.getId(), String.format("Здравствуйте %s Ваш баланс: %s \n Для поиска свободных ТС введите /search \n Для просмотра истории поездок и баланса /info", user.getUserName(), userDto.getBalance()), ParseMode.HTML, false);

            }
            else {
                userDto = userService.createUser(user.getUserName(), user.getFirstName(), user.getLastName(), "12345", RoleType.USER);
                userDto.setBalance(new BigDecimal("10000"));
                userDto = userService.saveUser(userDto);
                utils.send(absSender,
                        chat.getId(),
                        String.format("Добро пожаловать %s, Ваш временный пароль %s, Ваш баланс %dр",
                                userDto.getLogin(), userDto.getPassword(), userDto.getBalance()),
                        ParseMode.HTML,
                        false);
            }
        }
        catch (Exception ex) {
            log.error("Ошибка обработки команды start", ex);
        }
    }
}
