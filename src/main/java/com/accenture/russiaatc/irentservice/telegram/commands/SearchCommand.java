package com.accenture.russiaatc.irentservice.telegram.commands;

import com.accenture.russiaatc.irentservice.model.dto.TransportShortDto;
import com.accenture.russiaatc.irentservice.service.transport.TransportService;
import com.accenture.russiaatc.irentservice.telegram.TelegramUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

@Slf4j
@Component
public class SearchCommand extends BaseCommand {

    private final TransportService transportService;

    public SearchCommand(TelegramUtils utils, TransportService transportService) {
        super("search", "search command", utils);
        this.transportService = transportService;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        log.info("Telegram SEARCH command received");
        try {

            StringBuilder sb = new StringBuilder();

            List<TransportShortDto> transportList = transportService.findAllFree();

            if (transportList != null && !transportList.isEmpty()) {
                for (TransportShortDto tsd : transportList) {
                    sb.append(String.format("Доступен %s '%s'\n(для создания аренты дайте команду /rent %s)\n\n", tsd.getId(), tsd.getType(), tsd.getSerial()));
                }
            }
            else {
                sb.append("Свободных ТС нет.");
            }

            utils.send(absSender, chat.getId(), sb.toString(), ParseMode.HTML, false);
        }
        catch (Exception ex) {
            log.error("Ошибка обработки команды search", ex);
        }
    }
}
