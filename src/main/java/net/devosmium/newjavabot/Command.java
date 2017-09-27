package net.devosmium.newjavabot;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.List;

/**
 * Created by Owen Salter on 26-Sep-17.
 */
public interface Command {

    void runCommand(MessageReceivedEvent event, List<String> args);

}
