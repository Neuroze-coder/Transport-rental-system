package com.accenture.russiaatc.irentservice.telegram.commands;

import com.accenture.russiaatc.irentservice.telegram.TelegramUtils;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;

@Slf4j
public abstract class BaseCommand extends BotCommand {

    protected final TelegramUtils utils;

    public BaseCommand(String commandIdentifier, String description, TelegramUtils utils) {
        super(commandIdentifier, description);
        this.utils = utils;
    }
}
