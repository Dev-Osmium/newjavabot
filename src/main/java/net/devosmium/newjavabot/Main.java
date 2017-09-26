package net.devosmium.newjavabot;

import sx.blah.discord.api.IDiscordClient;

public class Main {

    public static void main(String[] args) {

        if(args.length != 1){
            System.out.println("Please enter the bots token as the first argument e.g java -jar thisjar.jar tokenhere");
            return;
        }

        IDiscordClient cli = BotUtils.getBuiltDiscordClient(args[0]);

        cli.getDispatcher().registerListener(new CommandHandler());
        cli.login();
    }

}