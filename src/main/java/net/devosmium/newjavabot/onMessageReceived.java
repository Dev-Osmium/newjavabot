package net.devosmium.newjavabot;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class onMessageReceived {

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "test"))
            BotUtils.sendMessage(event.getChannel(), "I am sending a message from an EventSubscriber listener");
        else if (event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "ping")) {
            BotUtils.sendMessage((event.getChannel(), "pong"));
        }
    }

}