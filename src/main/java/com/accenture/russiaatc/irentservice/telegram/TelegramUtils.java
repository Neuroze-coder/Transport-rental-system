package com.accenture.russiaatc.irentservice.telegram;

import com.accenture.russiaatc.irentservice.error.BusinessRuntimeException;
import com.accenture.russiaatc.irentservice.error.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class TelegramUtils {
    public void send(AbsSender sender,
                     Long chatId,
                     String text,
                     String parseMode,
                     boolean enableMarkdown) {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId.toString());
        msg.enableMarkdown(enableMarkdown);
        msg.setText(text);
        try {
            sender.execute(msg);
        } catch (TelegramApiException e) {
            log.error("Ошибка отправки сообщения пользователю", e);
            throw new BusinessRuntimeException(ErrorCodeEnum.TELEGRAM_MESSAGE_SEND_ERROR);
        }
    }
}
