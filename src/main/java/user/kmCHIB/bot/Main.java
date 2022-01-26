package user.kmCHIB.bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import user.kmCHIB.bot.commands.testSheetsListener;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDABuilder SheetsIO = JDABuilder.createDefault("OTM1NzY0NzA1NTIyMzg0ODk2.YfDYyw.3SDIrDW8A29ZDi_qVa_-6ju-Abs",
                GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS).setActivity(Activity.playing("Google Sheets!"));
        SheetsIO.addEventListeners(new testSheetsListener());
        SheetsIO.build();

//
    }
}
