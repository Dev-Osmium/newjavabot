package net.devosmium.newjavabot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.*;

/**
 * Updated command handler
 * Created by Owen Salter on 26-Sep-17.
 */
public class CommandHandler {

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] argArray = event.getMessage().getContent().split(" ");

        if (argArray.length == 0) return;

        if (argArray[0].startsWith(BotUtils.BOT_PREFIX)) return;

        String commandStr = argArray[0].substring(1);

        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0);

        switch (commandStr) {

            case "test":
                testCommand(event, argsList);
                break;

        }

    }


    private void testCommand(MessageReceivedEvent event, List<String> args){

        BotUtils.sendMessage(event.getChannel(), "You ran the test command with args: " + args);

    }


}
