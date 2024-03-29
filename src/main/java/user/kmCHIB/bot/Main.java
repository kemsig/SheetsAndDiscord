package user.kmCHIB.bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import user.kmCHIB.bot.commands.sheetReactionListener;
import user.kmCHIB.bot.commands.sheetsSetup;
import user.kmCHIB.bot.commands.testSheetsListener;
import user.kmCHIB.bot.misc.heldData;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDABuilder SheetsIO = JDABuilder.createDefault("",
                GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_EMOJIS,
                        GatewayIntent.DIRECT_MESSAGES)
                .setActivity(Activity.playing("Google Sheets!")
                );
        SheetsIO.addEventListeners(new sheetsSetup(), new sheetReactionListener(), new testSheetsListener());
        SheetsIO.build();


    }
}
