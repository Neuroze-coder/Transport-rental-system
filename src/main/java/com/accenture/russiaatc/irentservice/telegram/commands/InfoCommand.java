package com.accenture.russiaatc.irentservice.telegram.commands;

import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import com.accenture.russiaatc.irentservice.model.dto.UserDto;
import com.accenture.russiaatc.irentservice.service.rent.RentService;
import com.accenture.russiaatc.irentservice.service.user.UserService;
import com.accenture.russiaatc.irentservice.telegram.TelegramUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

@Slf4j
@Component
public class InfoCommand  extends BaseCommand  {

    private final TelegramUtils utils;
    private final UserService userService;
    private final RentService rentService;

    @Autowired
    public InfoCommand(TelegramUtils utils, TelegramUtils utils1, UserService userService, RentService rentService) {
        super("info", "info command", utils);
        this.utils = utils1;
        this.userService = userService;
        this.rentService = rentService;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        log.info("Telegram INFO command received");
        try {
            UserDto userDto = userService.findByLogin(user.getUserName());

            StringBuilder sb = new StringBuilder();

            if (userDto == null) {
                sb.append(String.format("Пользователь %s не найден. Воспользуйтесь командой /start для регистрации.", user.getUserName()));
            }
            else {
                sb.append(String.format("Ваш логин: %s\n", user.getUserName()));
                sb.append(String.format("Ваш пароль: %s\n", userDto.getPassword()));
                sb.append(String.format("Ваш балланс: %s\n", userDto.getBalance()));

                List<RentDto> rents = null;

                try {
                    rents = rentService.findByUserId(userDto.getId());
                } catch (Exception e) {
                    log.error("Ошибка получения списка поездок", e);
                    sb.append("Вас еще не было поездок\n");
                }

                if (rents != null) {
                    for (RentDto t : rents) {
                        sb.append(String.format("\n Поездка %s, ТС %s, начало %s, окончание %s, стоимость %s",
                                t.getId(), t.getVehicle().getSerial(), t.getStartDateTime(), t.getEndDateTime(), t.getTotalPrice()));
                    }
                }
            }

            utils.send(absSender, chat.getId(), sb.toString(), ParseMode.HTML, false);
        }
        catch (Exception ex) {
            log.error("Ошибка обработки команды info", ex);
        }
    }
}
