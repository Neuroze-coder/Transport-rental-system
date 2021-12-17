package com.accenture.russiaatc.irentservice.telegram.commands;

import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import com.accenture.russiaatc.irentservice.model.dto.TransportShortDto;
import com.accenture.russiaatc.irentservice.service.rent.RentService;
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
public class FinishCommand extends BaseCommand {
    private final TelegramUtils utils;
    private final RentService rentService;

    @Autowired
    public FinishCommand(TelegramUtils utils, RentService rentService) {
        super("end", "end command", utils);
        this.utils = utils;
        this.rentService = rentService;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        log.info("Telegram FINISH command received");
        try {
            String message;
            Long rentId = Long.parseLong(strings[0]);
            RentDto finishedRentDto = rentService.closeRent(rentId);
            StringBuilder sb = new StringBuilder();

            if (finishedRentDto != null) {

                message = String.format("Вы успешно завершили поездку №: %d, стоимость %s", finishedRentDto.getId(), finishedRentDto.getTotalPrice());

            }
            else {
                message = "Ошибка. Введите корректный id поездки (проверьте командой /info).";
            }
            utils.send(absSender, chat.getId(), message, ParseMode.HTML,false);
        }
        catch (Exception ex) {
            log.error("Ошибка обработки команды finish", ex);
        }
    }
}
