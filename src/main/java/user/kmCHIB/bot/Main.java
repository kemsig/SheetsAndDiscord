package user.kmCHIB.bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import user.kmCHIB.bot.commands.heldData;
import user.kmCHIB.bot.commands.sheetReactionListener;
import user.kmCHIB.bot.commands.sheetsSetup;
import user.kmCHIB.bot.commands.testSheetsListener;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDABuilder SheetsIO = JDABuilder.createDefault("OTM1NzY0NzA1NTIyMzg0ODk2.YfDYyw.3SDIrDW8A29ZDi_qVa_-6ju-Abs",
                GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_EMOJIS,
                        GatewayIntent.DIRECT_MESSAGES)
                .setActivity(Activity.playing("Google Sheets!")
                );
        SheetsIO.addEventListeners(new sheetsSetup(), new sheetReactionListener());
        SheetsIO.build();

    }
}
