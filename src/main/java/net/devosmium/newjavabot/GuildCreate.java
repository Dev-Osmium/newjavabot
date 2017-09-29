package net.devosmium.newjavabot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.GuildCreateEvent;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Owen Salter on 28-Sep-17.
 */
public class GuildCreate {



    @EventSubscriber
    public void onGuildCreate(GuildCreateEvent event) {

        //Initialize the database
        initDB(event);

    }

    public static void initDB (GuildCreateEvent event) {
        Connection connection = null;
        String url = "jdbc:sqlite:./data/" + event.getGuild().getStringID() + ".db";
        String sql = "CREATE TABLE IF NOT EXISTS " + event.getGuild().getStringID() + "-settings (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	log_channel int NOT NULL,\n"
                + "	ownerid int NOT NULL\n"
                + ");";
        try {
            Statement stmt = connection.createStatement();
                // create a new table
                stmt.execute(sql);

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
