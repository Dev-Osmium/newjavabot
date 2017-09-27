package net.devosmium.newjavabot;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.impl.obj.Embed;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RateLimitException;
import sx.blah.discord.util.RequestBuffer;

class BotUtils {

    // Constants for use throughout the bot
    static String BOT_PREFIX = "/";
    static String RECOG_NAME = "NewBot";

    // Handles the creation and getting of a IDiscordClient object for a token
    static IDiscordClient getBuiltDiscordClient(String token){

        // The ClientBuilder object is where you will attach your params for configuring the instance of your bot.
        // Such as withToken, setDaemon etc
        return new ClientBuilder()
                .withToken(token)
                .build();

    }

    // Helper functions to make certain aspects of the bot easier to use.
    static void sendMessage(IChannel channel, String description, String title, MessageReceivedEvent event, Boolean isSuccess){

        // This might look weird but it'll be explained in another page.
        RequestBuffer.request(() -> {
            try{
                EmbedBuilder builder = new EmbedBuilder();

                builder.withAuthorName(BotUtils.RECOG_NAME);
                builder.withAuthorIcon("http://i.imgur.com/PB0Soqj.png");
                builder.withAuthorUrl("http://i.imgur.com/oPvYFj3.png");

                if (isSuccess) {
                    builder.withColor(0, 255, 0);
                } else {
                    builder.withColor(255,0,0);
                }
                builder.withDesc(description);
                builder.withDescription(description);
                builder.withTitle(title);
                builder.withTimestamp(100);

                RequestBuffer.request(() -> event.getChannel().sendMessage(builder.build()));
            } catch (DiscordException e){
                System.err.println("Message could not be sent with error: ");
                e.printStackTrace();
            }
        });

        /*
        // The below example is written to demonstrate sending a message if you want to catch the RLE for logging purposes
        RequestBuffer.request(() -> {
            try{
                channel.sendMessage(message);
            } catch (RateLimitException e){
                System.out.println("Do some logging");
                throw e;
            }
        });
        */

    }

    static void decentEmbedBuilder(String title, String author) {

    }
}
